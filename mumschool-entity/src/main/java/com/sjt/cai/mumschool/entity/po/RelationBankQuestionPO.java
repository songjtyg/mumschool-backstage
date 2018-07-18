package com.sjt.cai.mumschool.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2018-07-18
 */
@TableName("relation_bank_question")
public class RelationBankQuestionPO extends Model<RelationBankQuestionPO> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("question_bank_id")
	private Integer questionBankId;
	@TableField("question_id")
	private Integer questionId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RelationBankQuestionPO{" +
			", id=" + id +
			", questionBankId=" + questionBankId +
			", questionId=" + questionId +
			"}";
	}
}
