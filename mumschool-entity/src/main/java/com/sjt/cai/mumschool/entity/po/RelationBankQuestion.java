package com.sjt.cai.mumschool.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-24
 */
@TableName("relation_bank_question")
public class RelationBankQuestion extends Model<RelationBankQuestion> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("question_bank_id")
	private Integer questionBankId;
	@TableField("question_id")
	private Integer questionId;
	private Integer seq;


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

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RelationBankQuestion{" +
			", id=" + id +
			", questionBankId=" + questionBankId +
			", questionId=" + questionId +
			", seq=" + seq +
			"}";
	}
}
