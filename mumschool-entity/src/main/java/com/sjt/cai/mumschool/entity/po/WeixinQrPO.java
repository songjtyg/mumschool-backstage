package com.sjt.cai.mumschool.entity.po;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-25
 */
@TableName("weixin_qr")
public class WeixinQrPO extends Model<WeixinQrPO> {

    private static final long serialVersionUID = 1L;
	public static final int MAX_BASE_SNUM = 100000;


	public final static int REPASSWORD_TYPE = 1;
	public final static int SET_GROUP_TYPE = 2;
	public final static int SIGN_IN = 3;	//签到
	public final static int SIGN_OUT = 4;	//签退
	public final static int EXAM = 5;		//考试
	public static final int TEMP_LOGIN = 11;//todo 到底是什么值？
	public final static int TYPE_BIND = 12;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String name;
	private Integer type;
	private Integer status;
	private Integer snum;
	private String msg;
	@TableField("qr_data")
	private String qrData;
	@TableField("create_date")
	private Date createDate;

	private String ticket;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSnum() {
		return snum;
	}

	public void setSnum(Integer snum) {
		this.snum = snum;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getQrData() {
		return qrData;
	}

	public void setQrData(String qrData) {
		this.qrData = qrData;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "WeixinQrPO{" +
			", id=" + id +
			", name=" + name +
			", type=" + type +
			", status=" + status +
			", snum=" + snum +
			", msg=" + msg +
			", qrData=" + qrData +
			", createDate=" + createDate +
			"}";
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
