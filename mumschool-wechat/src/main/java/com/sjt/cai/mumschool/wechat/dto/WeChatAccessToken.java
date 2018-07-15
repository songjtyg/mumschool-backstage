package com.sjt.cai.mumschool.wechat.dto;

import lombok.Data;

@Data
public class WeChatAccessToken {
	private String access_token;
	private String expires_in;

}
