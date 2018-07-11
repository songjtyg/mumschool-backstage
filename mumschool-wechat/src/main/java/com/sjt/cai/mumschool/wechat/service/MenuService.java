package com.sjt.cai.mumschool.wechat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.wechat.dto.WeixinMenuDto;

import java.util.List;

public interface MenuService {
	void publishMenu(List<WeixinMenuDto> wmds) throws JsonProcessingException;
	String queryMenu();
}
