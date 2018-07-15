package com.sjt.cai.mumschool.wechat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.wechat.dto.WeChatMenuDto;

import java.util.List;

public interface WeChatMenuService {
	void publishMenu(List<WeChatMenuDto> wmds) throws JsonProcessingException;
	String queryMenu();
}
