package com.guapixu.user.controller;

import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.user.pojo.vo.MailCodeVO;
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
    public ResultVO<?> sendMailCode(@Validated @RequestBody MailCodeVO mailCodeVO){
        logger.info("传入参数==>{}", mailCodeVO);
        return loginService.sendMailCode(mailCodeVO);
    }
}
