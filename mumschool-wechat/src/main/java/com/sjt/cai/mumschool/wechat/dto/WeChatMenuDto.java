package com.sjt.cai.mumschool.wechat.dto;

import java.util.ArrayList;
import java.util.List;

public class WeChatMenuDto {
	private int id;
	private String name;
	private String key;
	private String type;
	private String url;
	private List<WeChatMenuDto> sub_button = new ArrayList<WeChatMenuDto>();

	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<WeChatMenuDto> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WeChatMenuDto> sub_button) {
		this.sub_button = sub_button;
	}
}
