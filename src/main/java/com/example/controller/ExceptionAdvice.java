package com.example.controller;

import com.example.dto.BaseResp;
import com.example.enums.RespStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public BaseResp exception(Exception e) {
        log.error(e.getLocalizedMessage(), e);
        BaseResp resp = new BaseResp();
        resp.setMessage(RespStatusEnum.SYSTEM_ERROR.getMessage());
        resp.setStatus(RespStatusEnum.SYSTEM_ERROR.getStatusCode());
        return resp;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResp validationBodyException(MethodArgumentNotValidException exception){
        StringBuffer buffer = new StringBuffer();

        BindingResult result  = exception.getBindingResult();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                buffer.append(fieldError.getDefaultMessage()).append(",");
            });
        }

        log.debug(buffer.toString());
        BaseResp resp = new BaseResp();
        resp.setMessage(buffer.toString());
        resp.setStatus(RespStatusEnum.PARAM_ERROR.getStatusCode());
        return resp;
    }
    
    
    
}
