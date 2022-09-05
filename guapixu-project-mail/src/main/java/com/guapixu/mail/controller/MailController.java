package com.guapixu.mail.controller;

import com.guapixu.commons.constant.ResultCode;
import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.feign.pojo.vo.MailSendVO;
import com.guapixu.mail.service.MailService;
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
@RequestMapping("/mail")
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "mailService")
    private MailService mailService;

    /**
     * 邮件发送请求入口
     * @param mailSendVO 发件参数
     * @return 邮件发送结果
     */
    @PostMapping("/send")
    public ResultVO<?> sendMail(@Validated @RequestBody MailSendVO mailSendVO){
        logger.info("邮件发送接口被调用==>{}",mailSendVO);
        if (mailSendVO.getHtml()){
            mailService.sendHtmlMail(mailSendVO.getEmail(),mailSendVO.getSubject(),mailSendVO.getContent());
            return new ResultVO<>(ResultCode.SUCCESS);
        }
        mailService.sendSimpleMail(mailSendVO.getEmail(),mailSendVO.getSubject(),mailSendVO.getContent());
        return new ResultVO<>(ResultCode.SUCCESS);
    }
}
