package com.sjt.cai.mumschool.wechat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeixinContext {
	private String appId;
	private String appSecurt;
	private String baseUrl;
	private String token;
	private AccessToken accessToken;
	private static WeixinContext wc;

	public WeixinContext(){}
	public static WeixinContext getInstance() {
		if(wc==null) wc = new WeixinContext();
		return wc;
	}

}
