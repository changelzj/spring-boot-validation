package com.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RespStatusEnum {
    
    SUCCESS(200, "成功"),
    PARAM_ERROR(501, "参数错误"),
    SYSTEM_ERROR(500, "系统未知错误"),
    BUSINESS_ERROR(502, "业务错误");
    
    private Integer statusCode;
    
    private String message;
    
}
