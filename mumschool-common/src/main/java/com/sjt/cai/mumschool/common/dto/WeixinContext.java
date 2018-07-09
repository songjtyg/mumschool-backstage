package com.sjt.cai.mumschool.common.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
