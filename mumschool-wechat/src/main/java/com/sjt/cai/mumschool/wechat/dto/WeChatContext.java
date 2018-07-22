package com.sjt.cai.mumschool.wechat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeChatContext {
	private String appId;
	private String appSecurt;
	private String baseUrl;
	private String token;
	private WeChatAccessToken weChatAccessToken;
	private WeChatTicket weChatTicket;
	private static WeChatContext wc;

	public WeChatContext(){}
	public static WeChatContext getInstance() {
		if(wc==null) wc = new WeChatContext();
		return wc;
	}

}
