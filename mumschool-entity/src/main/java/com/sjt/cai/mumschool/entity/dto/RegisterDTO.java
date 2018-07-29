package com.sjt.cai.mumschool.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterDTO {
    private Integer userType;
    private String userName;
    private String password;
    private String hospital;
    private String department;
    private String phone;
    private Integer gestationalWeeks;
    private String preHospital;
    private Integer gender;
    private Date birthday;
    private String verifyCode;
}
