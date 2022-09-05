package com.guapixu.commons.constant;

import lombok.Getter;

/**
 * @author lizx
 */
@Getter
public enum ResultCode implements StatusCode {
    // 请求成功
    SUCCESS(1000,"请求成功"),

    // redis中没有登录验证码
    LOGIN_CODE_NOT_FOUND(1101,"登入验证码已失效或不存在"),
    // 登录验证码不正确
    LOGIN_CODE_ERROR(1102,"登录验证码错误"),

    // 参数校验失败
    VALIDATE_ERROR(9000,"参数校验失败"),

    // 请求失败
    FAIL(9999,"请求失败");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
