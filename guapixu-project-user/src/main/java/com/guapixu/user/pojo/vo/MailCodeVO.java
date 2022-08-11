package com.guapixu.user.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author lizx
 */
@Data
public class MailCodeVO implements Serializable {
    @NotNull(message = "邮箱地址不能为空")
    @Pattern(regexp = "^([A-Za-z0-9_\\-\\.])+@([A-Za-z0-9_\\-\\.])+.([A-Za-z]{2,4})$", message = "邮箱地址不合规")
    private String email;
}
