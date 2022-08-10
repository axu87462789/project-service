package com.guapixu.mail.controller;

import com.guapixu.commons.constant.ResultCode;
import com.guapixu.commons.constant.StatusCode;
import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.mail.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lizx
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Resource(name = "mailService")
    private MailService mailService;

    @PostMapping("/send")
    public ResultVO sendMail(){

        return new ResultVO(ResultCode.SUCCESS);
    }
}
