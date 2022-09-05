package com.guapixu.user.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.guapixu.commons.constant.ResultCode;
import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.feign.client.mail.MailClient;
import com.guapixu.feign.pojo.vo.MailSendVO;
import com.guapixu.user.config.PatternProperties;
import com.guapixu.user.dao.UserDao;
import com.guapixu.user.pojo.po.UserPO;
import com.guapixu.user.pojo.vo.LoginVO;
import com.guapixu.user.service.LoginService;
import com.guapixu.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author lizx
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "patternProperties")
    private PatternProperties patternProperties;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource(name = "userService")
    private UserService userService;

    @Override
    public void sendMailCode(LoginVO loginVO) {
        // 生成随机六位验证码
        String code = RandomUtil.randomNumbers(6);
        // 向redis中存入验证码
        redisTemplate.opsForValue().set(patternProperties.getRedisKeyPrefix()+"loginCode:"+ loginVO.getEmail(),code,600L, TimeUnit.SECONDS);
        // 发送验证码邮件
        String content = "您正尝试通过邮箱验证码登入平台。<br>验证码：" + code + "<br>有效时间为10分钟。瓜皮嘘平台欢迎您的使用！";
        MailSendVO mailSendVO = new MailSendVO();
        mailSendVO.setEmail(loginVO.getEmail());
        mailSendVO.setSubject(patternProperties.getLoginCodeMailSubject());
        mailSendVO.setContent(content);
        mailSendVO.setHtml(true);
        rabbitTemplate.convertAndSend("queue.guapixu.loginMailCode",mailSendVO);
    }

    @Override
    public ResultVO<?> loginMailCode(LoginVO loginVO) {
        // 取验证码并校验
        String code =(String) redisTemplate.opsForValue().get(patternProperties.getRedisKeyPrefix() + "loginCode:" + loginVO.getEmail());
        if (StrUtil.isNullOrUndefined(code)){
            return new ResultVO<>(ResultCode.LOGIN_CODE_NOT_FOUND);
        }
        if(!StrUtil.equals(code,loginVO.getCode())){
            return new ResultVO<>(ResultCode.LOGIN_CODE_ERROR);
        }
        // 查询用户，不存在则注册
        UserPO user = userService.lambdaQuery()
                .eq(UserPO::getEmail,loginVO.getEmail())
                .one();
        if (ObjectUtil.isNull(user)){
            user = userService.saveUserWithEmail(loginVO.getEmail());
        }
        return new ResultVO<>(ResultCode.SUCCESS,user);
    }
}
