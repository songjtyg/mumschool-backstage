package com.sjt.cai.mumschool.entity.dto;

import lombok.Data;

@Data
public class NextQuestionDTO {
    private Integer examId;
    private Integer questionId;
    private Integer questionBankId;
}
