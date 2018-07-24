package com.sjt.cai.mumschool.entity.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String registType;
    private String userName;
    private String password;
    private String hospital;
    private String department;
    private String phone;

}
