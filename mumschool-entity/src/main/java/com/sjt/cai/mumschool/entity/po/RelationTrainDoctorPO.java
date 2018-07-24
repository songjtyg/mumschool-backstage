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
 * @since 2018-07-24
 */
@TableName("relation_train_doctor")
public class RelationTrainDoctorPO extends Model<RelationTrainDoctorPO> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@TableField("train_id")
	private Integer trainId;
	@TableField("doctor_id")
	private Integer doctorId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RelationTrainDoctorPO{" +
			", id=" + id +
			", trainId=" + trainId +
			", doctorId=" + doctorId +
			"}";
	}
}
