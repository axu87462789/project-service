package com.guapixu.user.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author lizx
 */
@Data
public class LoginVO implements Serializable {
    @NotBlank(message = "邮箱地址不能为空", groups = {Mail.class,MailCode.class})
    @Pattern(regexp = "^([A-Za-z0-9_\\-\\.])+@([A-Za-z0-9_\\-\\.])+.([A-Za-z]{2,4})$", message = "邮箱地址不合规", groups = {Mail.class,MailCode.class})
    private String email;

    @NotBlank(message = "验证码不能为空", groups = {MailCode.class})
    private String code;

    public interface Mail{}
    public interface MailCode{}
}
