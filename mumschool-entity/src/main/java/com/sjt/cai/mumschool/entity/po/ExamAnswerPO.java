package com.sjt.cai.mumschool.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-24
 */
@TableName("exam_answer")
public class ExamAnswerPO extends Model<ExamAnswerPO> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("exam_id")
	private Integer examId;
	@TableField("questin_bank_Id")
	private Integer questinBankId;
	@TableField("question_id")
	private Integer questionId;
	private String choices;
	private Boolean correct;
	private Integer score;
	private Integer creater;
	@TableField("create_time")
	private Date createTime;
	private Integer modifier;
	@TableField("modify_time")
	private Date modifyTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Integer getQuestinBankId() {
		return questinBankId;
	}

	public void setQuestinBankId(Integer questinBankId) {
		this.questinBankId = questinBankId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public Boolean getCorrect() {
		return correct;
	}

	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getCreater() {
		return creater;
	}

	public void setCreater(Integer creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getModifier() {
		return modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ExamAnswerPO{" +
			", id=" + id +
			", examId=" + examId +
			", questinBankId=" + questinBankId +
			", questionId=" + questionId +
			", choices=" + choices +
			", correct=" + correct +
			", score=" + score +
			", creater=" + creater +
			", createTime=" + createTime +
			", modifier=" + modifier +
			", modifyTime=" + modifyTime +
			"}";
	}
}
