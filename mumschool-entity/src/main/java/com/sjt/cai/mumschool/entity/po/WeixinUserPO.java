package com.sjt.cai.mumschool.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-14
 */
@TableName("weixin_user")
public class WeixinUserPO extends Model<WeixinUserPO> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String openid;
	private String nickname;
	private Integer sex;
	private String language;
	private String country;
	private String province;
	private String city;
	private String headimgurl;
	private Date subscribe_time;
	private String remark;
	private Integer groupid;
	private String tagid_list;
	private String subscribe_scene;
	private Integer qr_scene;
	private String qr_scene_str;

	private String loginName;
	private String phone;
	private String userName;
	private String password;
	private Integer status;
	private Integer bind;
	private Integer userType;
	private Long creater;
	private Date createTime;
	private Long modifier;
	private Date modifyTime;

	private Boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Date getSubscribe_time() {
		return subscribe_time;
	}

	public void setSubscribe_time(Date subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getTagid_list() {
		return tagid_list;
	}

	public void setTagid_list(String tagid_list) {
		this.tagid_list = tagid_list;
	}

	public String getSubscribe_scene() {
		return subscribe_scene;
	}

	public void setSubscribe_scene(String subscribe_scene) {
		this.subscribe_scene = subscribe_scene;
	}

	public Integer getQr_scene() {
		return qr_scene;
	}

	public void setQr_scene(Integer qr_scene) {
		this.qr_scene = qr_scene;
	}

	public String getQr_scene_str() {
		return qr_scene_str;
	}

	public void setQr_scene_str(String qr_scene_str) {
		this.qr_scene_str = qr_scene_str;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getBind() {
		return bind;
	}

	public void setBind(Integer bind) {
		this.bind = bind;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getCreater() {
		return creater;
	}

	public void setCreater(Long creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getModifier() {
		return modifier;
	}

	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "WeixinUserPO{" +
				"id=" + id +
				", openid='" + openid + '\'' +
				", nickname='" + nickname + '\'' +
				", sex=" + sex +
				", language='" + language + '\'' +
				", country='" + country + '\'' +
				", province='" + province + '\'' +
				", city='" + city + '\'' +
				", headimgurl='" + headimgurl + '\'' +
				", subscribe_time=" + subscribe_time +
				", remark='" + remark + '\'' +
				", groupid=" + groupid +
				", tagid_list='" + tagid_list + '\'' +
				", subscribe_scene='" + subscribe_scene + '\'' +
				", qr_scene=" + qr_scene +
				", qr_scene_str='" + qr_scene_str + '\'' +
				", loginName='" + loginName + '\'' +
				", phone='" + phone + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", status=" + status +
				", bind=" + bind +
				", userType=" + userType +
				", creater=" + creater +
				", createTime=" + createTime +
				", modifier=" + modifier +
				", modifyTime=" + modifyTime +
				", active=" + active +
				'}';
	}
}
