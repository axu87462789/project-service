package com.guapixu.feign.client.mail;

import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.feign.pojo.vo.MailSendVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lizx
 */
@FeignClient(value = "guapixu-project-mail")
@RequestMapping("/mail")
public interface MailClient {
    /**
     * 邮件发送请求入口
     * @param mailSendVO 发件参数
     * @return 邮件发送结果
     */
    @PostMapping("/send")
    ResultVO<?> sendMail(@Validated @RequestBody MailSendVO mailSendVO);
}
