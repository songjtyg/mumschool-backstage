package com.sjt.cai.mumschool.common.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.common.dto.WeixinMenuDto;

import java.util.List;

public interface MenuService {
	void publishMenu(List<WeixinMenuDto> wmds) throws JsonProcessingException;
	String queryMenu();
}
