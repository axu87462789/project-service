package com.guapixu.commons.advice;

import com.guapixu.commons.constant.ResultCode;
import com.guapixu.commons.pojo.vo.ResultVO;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常统一处理
 * @author lizx
 */
@RestControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler({BindException.class})
    public ResultVO<String> argValidExceptionHandler(BindException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVO<>(ResultCode.VALIDATE_ERROR, objectError.getDefaultMessage());
    }
}
