package com.guapixu.user.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.feign.client.mail.MailClient;
import com.guapixu.feign.pojo.vo.MailSendVO;
import com.guapixu.user.config.PatternProperties;
import com.guapixu.user.pojo.vo.MailCodeVO;
import com.guapixu.user.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lizx
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "patternProperties")
    private PatternProperties patternProperties;

    @Resource
    private MailClient mailClient;

    @Override
    public ResultVO<?> sendMailCode(MailCodeVO mailCodeVO) {
        String code = RandomUtil.randomNumbers(6);
        String content = "您正尝试通过邮箱验证码登入平台。<br>验证码：" + code + "<br>瓜皮嘘平台欢迎您的使用！";
        MailSendVO mailSendVO = new MailSendVO();
        mailSendVO.setEmail(mailCodeVO.getEmail());
        mailSendVO.setSubject(patternProperties.getLoginCodeMailSubject());
        mailSendVO.setContent(content);
        mailSendVO.setHtml(true);
        return mailClient.sendMail(mailSendVO);
    }
}
