package com.guapixu.user.controller;

import com.guapixu.commons.constant.ResultCode;
import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.user.pojo.vo.LoginVO;
import com.guapixu.user.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lizx
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "loginService")
    private LoginService loginService;

    @PostMapping("/sendMailCode")
    public ResultVO<?> sendMailCode(@Validated(LoginVO.Mail.class) @RequestBody LoginVO loginVO){
        logger.info("发送邮箱验证码==>{}", loginVO);
        loginService.sendMailCode(loginVO);
        return new ResultVO<>(ResultCode.SUCCESS);
    }

    @PostMapping("/loginMailCode")
    public ResultVO<?> loginMailCode(@Validated(LoginVO.MailCode.class) @RequestBody LoginVO loginVO){
        logger.info("邮箱验证码登入==>{}", loginVO);
        return loginService.loginMailCode(loginVO);
    }
}
