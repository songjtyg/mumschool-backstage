package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeixinMenuDto;
import com.sjt.cai.mumschool.wechat.service.MenuService;
import com.sjt.cai.mumschool.wechat.util.WeixinBasicKit;
//import org.konghao.basic.service.IWeixinMenuService;
//import org.konghao.basic.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Override
	public void publishMenu(List<WeixinMenuDto> wmds) throws JsonProcessingException {
		String url = WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.MENU_ADD);
		System.out.println(url);
;
		Map<String,List<WeixinMenuDto>> maps = new HashMap<String,List<WeixinMenuDto>>();
		maps.put("button", wmds);
		//String json =  JsonUtil.getInstance().obj2json(maps);
		//转换器
		ObjectMapper mapper = new ObjectMapper();
		String json =  mapper.writeValueAsString(maps);

		System.out.println(json);
		String rel = WeixinBasicKit.sendJsonPost(url,json);
		if(!WeixinBasicKit.checkRequestSucc(rel)) {
			throw new RuntimeException("发布菜单失败："+WeixinBasicKit.getRequestMsg(rel));
		}
	}
	@Override
	public String queryMenu() {
		String url = WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.MENU_QUERY);
		return WeixinBasicKit.sendGet(url);
	}

}
