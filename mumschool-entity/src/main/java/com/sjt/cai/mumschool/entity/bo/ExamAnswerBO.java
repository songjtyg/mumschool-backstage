package com.sjt.cai.mumschool.entity.bo;

import lombok.Data;

import java.util.List;

@Data
public class ExamAnswerBO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private List<String> choices;
    private Boolean correct;
    private Integer score;
}