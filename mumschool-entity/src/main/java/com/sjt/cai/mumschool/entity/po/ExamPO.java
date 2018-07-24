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
 * @since 2018-07-23
 */
@TableName("exam")
public class ExamPO extends Model<ExamPO> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("user_id")
	private Integer userId;
	@TableField("question_bank_id")
	private Integer questionBankId;
	@TableField("correct_num")
	private Integer correctNum;
	private Integer score;
	@TableField("begin_time")
	private Date beginTime;
	@TableField("end_time")
	private Date endTime;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}

	public Integer getCorrectNum() {
		return correctNum;
	}

	public void setCorrectNum(Integer correctNum) {
		this.correctNum = correctNum;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
		return "ExamPO{" +
			", id=" + id +
			", userId=" + userId +
			", questionBankId=" + questionBankId +
			", correctNum=" + correctNum +
			", score=" + score +
			", beginTime=" + beginTime +
			", endTime=" + endTime +
			", creater=" + creater +
			", createTime=" + createTime +
			", modifier=" + modifier +
			", modifyTime=" + modifyTime +
			"}";
	}
}
