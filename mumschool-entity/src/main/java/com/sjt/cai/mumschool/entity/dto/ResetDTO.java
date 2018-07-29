package com.sjt.cai.mumschool.entity.dto;

import lombok.Data;

@Data
public class ResetDTO {
    private String loginWord;
    private String password;
    private String repeatPassword;
    private String verifyCode;
}
