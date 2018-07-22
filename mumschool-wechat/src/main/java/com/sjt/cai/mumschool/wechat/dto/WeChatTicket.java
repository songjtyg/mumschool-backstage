package com.sjt.cai.mumschool.wechat.dto;

import lombok.Data;

@Data
public class WeChatTicket {
	 private Integer errcode;
	 private String errmsg;
	 private String ticket;
	 Integer expires_in;
}
