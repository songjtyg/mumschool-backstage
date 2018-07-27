package com.sjt.cai.mumschool.entity.bo;

import lombok.Data;

import java.util.List;

@Data
public class ExamAnswerBO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer examId;
    private Integer questionBankId;
    private Integer questionId;
    private Integer score;
    private List<String> choices;
}