package com.hl.exceptions;

import com.hl.enums.ResultEnum;
import com.hl.exceptions.CustomException;
import com.hl.utils.SysResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常捕获(业务实现)
 *
 * @author NANDI_GUO
 * @date 2022/5/20 15:43
 */
@RestControllerAdvice
public class GlobalException extends RuntimeException {
    @ExceptionHandler(CustomException.class)
    public SysResult error(CustomException e){
        return SysResult.fail(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public SysResult exceptionHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        StringBuilder sbf = new StringBuilder();
        if (result.hasErrors()){
            List<FieldError> fieldErrorList = result.getFieldErrors();
            fieldErrorList.forEach(fieldError -> {
                if (sbf.length() > 0){
                    sbf.append(";");
                }
                sbf.append(fieldError.getDefaultMessage());
            });
        }
        return SysResult.fail(200, sbf.toString());
    }

    @ExceptionHandler(Exception.class)
    public SysResult error(Exception e){
        e.printStackTrace();
        return SysResult.fail(ResultEnum.SYSTEM_ERROR.getResultCode(),ResultEnum.SYSTEM_ERROR.getResultMsg());
    }


}
