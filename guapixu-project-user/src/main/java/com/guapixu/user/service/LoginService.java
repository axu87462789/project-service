package com.guapixu.user.service;

import com.guapixu.commons.pojo.vo.ResultVO;
import com.guapixu.user.pojo.vo.MailCodeVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lizx
 * @since 2022-08-02
 */
public interface LoginService {
    /**
     * 发送邮箱验证码邮件
     * @param mailCodeVO 邮箱信息
     * @return 发送结果
     */
    ResultVO<?> sendMailCode(MailCodeVO mailCodeVO);
}
