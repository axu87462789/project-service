package com.guapixu.commons.constant;

import lombok.Getter;

/**
 * @author lizx
 */
@Getter
public enum ResultCode implements StatusCode {
    // 请求成功
    SUCCESS(1000,"请求成功"),

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
