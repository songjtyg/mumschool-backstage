package com.sjt.cai.mumschool.entity.dto;

import lombok.Data;

@Data
public class ResetDto {
    private String loginWord;
    private String password;
    private String repeatPassword;
    private String identifyingCode;
}
