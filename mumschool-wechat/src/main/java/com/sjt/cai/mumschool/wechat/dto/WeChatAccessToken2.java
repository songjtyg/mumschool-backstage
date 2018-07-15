package com.sjt.cai.mumschool.wechat.dto;

import lombok.Data;

@Data
public class WeChatAccessToken2 {
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
}
