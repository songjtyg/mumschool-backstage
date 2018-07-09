package com.sjt.cai.mumschool.common.dto;

import lombok.Data;

@Data
public class AccessToken {
	private String access_token;
	private String expires_in;

}
