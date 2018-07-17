package com.sjt.cai.mumschool.entity.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String userName;
    private String password;
    private String hospital;
    private String department;
    private String phone;

}
