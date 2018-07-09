package com.sjt.cai.mumschool.entity.po;

import java.io.Serializable;

import java.util.Date;
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
 * @since 2018-06-25
 */
@TableName("weixin_qr")
public class WeixinQr extends Model<WeixinQr> {

    private static final long serialVersionUID = 1L;
	public static final int MAX_BASE_SNUM = 100000;

	public final static int REPASSWORD_TYPE = 1;
	public final static int SET_GROUP_TYPE = 2;
	public final static int TEMP_TYPE = 11;
	public final static int TYPE_BIND = 12;
	public static final int TEMP_LOGIN = 0;//todo 到底是什么值？

	private String id;
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "WeixinQr{" +
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
