package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.service.WeChatKfService;
import com.sjt.cai.mumschool.wechat.util.WeChatSecurityKit;
import com.sjt.cai.mumschool.wechat.util.WeChatBasicKit;

import java.util.HashMap;
import java.util.Map;

public class WeChatKfServiceImpl implements WeChatKfService {
    @Override
    public void add(String account,String nickname,String password) throws JsonProcessingException {
        String url = WeChatBasicKit.replaceAccessTokenUrl(WeChatFinalValue.KF_ADD);
        Map<String,String> maps = new HashMap<String,String>();
        maps.put("kf_account",account+"@gh_123456789");
        maps.put("nickname",nickname);
        maps.put("password", WeChatSecurityKit.md5(password));
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(maps);
        String json = WeChatBasicKit.sendJsonPost(url,content);
    }
}
