package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Param {
    
    @NotNull(message = "id不能为空")
    private Long id;
    
    @NotBlank(message = "name不能为空")
    private String name;
    
    @Valid
    @Size(min = 1, message = "details不能为空")
    private List<Detail> details;

    @Setter
    @Getter
    public static class Detail {
        
        @NotNull(message = "orderNo不能为空")
        private String orderNo;

        @NotNull(message = "orderTime不能为空")
        private Date orderTime;
    }
    
    
}
