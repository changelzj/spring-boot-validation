package com.example.controller;

import com.example.dto.BaseResp;
import com.example.dto.Param;
import com.example.enums.RespStatusEnum;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    
    @RequestMapping("input")
    public BaseResp input(@RequestBody @Validated Param param) {
        List<Param.Detail> details = param.getDetails();
        BaseResp resp = new BaseResp();
        resp.setMessage(RespStatusEnum.SUCCESS.getMessage());
        resp.setStatus(RespStatusEnum.SUCCESS.getStatusCode());
        return resp;
    }
    
}
