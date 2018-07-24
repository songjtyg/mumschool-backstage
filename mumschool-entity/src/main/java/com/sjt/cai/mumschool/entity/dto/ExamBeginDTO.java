package com.sjt.cai.mumschool.entity.dto;

import lombok.Data;

@Data
public class ExamBeginDTO {
    private Integer questionBankId;
    private String qrVerifyCode;
}
