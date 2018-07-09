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
 * @since 2018-06-19
 */
@TableName("t_user")
public class TUserPO extends Model<TUserPO> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String nickname;
	private String password;
	private String username;
	private String openid;
	@TableField("img_url")
	private String imgUrl;
	private Integer status;
	private Integer sex;
	private Integer bind;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getBind() {
		return bind;
	}

	public void setBind(Integer bind) {
		this.bind = bind;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TUserPO{" +
			", id=" + id +
			", nickname=" + nickname +
			", password=" + password +
			", username=" + username +
			", openid=" + openid +
			", imgUrl=" + imgUrl +
			", status=" + status +
			", sex=" + sex +
			", bind=" + bind +
			"}";
	}
}
