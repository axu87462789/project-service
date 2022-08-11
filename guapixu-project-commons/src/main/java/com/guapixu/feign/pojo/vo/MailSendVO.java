package com.guapixu.feign.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author lizx
 */
@Data
public class MailSendVO implements Serializable {
    /**
     * 收件人邮箱地址
     */
    @NotNull(message = "邮箱地址不能为空")
    @Pattern(regexp = "^([A-Za-z0-9_\\-\\.])+@([A-Za-z0-9_\\-\\.])+.([A-Za-z]{2,4})$", message = "邮箱地址不合规")
    private String email;

    /**
     * 邮件标题
     */
    @NotNull(message = "邮件标题不能为空")
    private String subject;

    /**
     * 邮件内容
     */
    @NotNull(message = "邮件内容不能为空")
    private String content;

    /**
     * 内容格式是否为html文档
     */
    @NotNull(message = "需指定邮件内容是否为html文档")
    private Boolean html;
}
