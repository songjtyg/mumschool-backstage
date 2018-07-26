package com.sjt.cai.mumschool.entity.bo;

import lombok.Data;

@Data
public class ExamAnswerBO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer examId;
    private Integer questionBankId;
    private Integer questionId;
    private String choices;
    private Integer score;
    private Integer creater;
    private Integer modifier;
}