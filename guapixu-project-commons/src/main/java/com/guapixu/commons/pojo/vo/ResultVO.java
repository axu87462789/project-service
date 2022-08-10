package com.guapixu.commons.pojo.vo;

import com.guapixu.commons.constant.StatusCode;
import lombok.Data;

/**
 * @author lizx
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;

    public ResultVO(Integer code, String msg){
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public ResultVO(Integer code, String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(StatusCode statusCode){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }

    public ResultVO(StatusCode statusCode,T data){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }
}
