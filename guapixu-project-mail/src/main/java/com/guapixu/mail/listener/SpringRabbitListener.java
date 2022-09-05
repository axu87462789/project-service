package com.guapixu.mail.listener;

import com.guapixu.commons.constant.ResultCode;
import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.feign.pojo.vo.MailSendVO;
import com.guapixu.mail.controller.MailController;
import com.guapixu.mail.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lizx
 */
@Component
public class SpringRabbitListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "mailService")
    private MailService mailService;

    @RabbitListener(queuesToDeclare = @Queue("queue.guapixu.loginMailCode"))
    public void listenLoginMailCodeQueueMessage(MailSendVO mailSendVO){
        logger.info("登录验证码邮件发送消息接收==>{}",mailSendVO);
        if (mailSendVO.getHtml()){
            mailService.sendHtmlMail(mailSendVO.getEmail(),mailSendVO.getSubject(),mailSendVO.getContent());
        }else {
            mailService.sendSimpleMail(mailSendVO.getEmail(), mailSendVO.getSubject(), mailSendVO.getContent());
        }
    }
}
