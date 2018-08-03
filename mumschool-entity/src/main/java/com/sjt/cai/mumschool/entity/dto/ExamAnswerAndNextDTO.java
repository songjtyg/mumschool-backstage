package com.sjt.cai.mumschool.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExamAnswerAndNextDTO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer examId;
    private Integer questionBankId;
    private Integer questionId;
    private List<String> choices;
    private Integer score;
    private Integer questionSeq;
}