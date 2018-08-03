package com.sjt.cai.mumschool.entity.bo;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class QuestionBO {

	private static final long serialVersionUID = 1L;

	private Integer id;
	/**
	 * 1-单选；2-多选
	 */
	private Integer type;
	private String content;
	private Integer score;
	private Integer questionBankId;
	private Integer seq;
	private ExamBO examBO;
	private ExamAnswerBO examAnswerBO;
	private List<QuestionOptionBO> questionOptionBOs;

}
