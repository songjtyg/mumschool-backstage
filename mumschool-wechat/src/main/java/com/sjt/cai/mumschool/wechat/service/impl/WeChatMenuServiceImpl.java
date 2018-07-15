package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeChatMenuDto;
import com.sjt.cai.mumschool.wechat.service.WeChatMenuService;
import com.sjt.cai.mumschool.wechat.util.WeChatBasicKit;
//import org.konghao.basic.service.IWeixinMenuService;
//import org.konghao.basic.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuService")
public class WeChatMenuServiceImpl implements WeChatMenuService {
	@Override
	public void publishMenu(List<WeChatMenuDto> wmds) throws JsonProcessingException {
		String url = WeChatBasicKit.replaceAccessTokenUrl(WeChatFinalValue.MENU_ADD);
		System.out.println(url);
;
		Map<String,List<WeChatMenuDto>> maps = new HashMap<String,List<WeChatMenuDto>>();
		maps.put("button", wmds);
		//String json =  JsonUtil.getInstance().obj2json(maps);
		//转换器
		ObjectMapper mapper = new ObjectMapper();
		String json =  mapper.writeValueAsString(maps);

		System.out.println(json);
		String rel = WeChatBasicKit.sendJsonPost(url,json);
		if(!WeChatBasicKit.checkRequestSucc(rel)) {
			throw new RuntimeException("发布菜单失败："+ WeChatBasicKit.getRequestMsg(rel));
		}
	}
	@Override
	public String queryMenu() {
		String url = WeChatBasicKit.replaceAccessTokenUrl(WeChatFinalValue.MENU_QUERY);
		return WeChatBasicKit.sendGet(url);
	}

}
