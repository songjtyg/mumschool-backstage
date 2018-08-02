package com.sjt.cai.mumschool.entity.dto;

import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.bo.QuestionBankBO;
import lombok.Data;

@Data
public class BankExamQuestionAnswerBO {
    private QuestionBankBO questionBankBO;
    private QuestionBO questionBO;
}
