package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.wechat.service.KfService;
import com.sjt.cai.mumschool.wechat.util.SecurityKit;
import com.sjt.cai.mumschool.wechat.util.WeixinBasicKit;

import java.util.HashMap;
import java.util.Map;

public class KfServiceImpl implements KfService {
    @Override
    public void add(String account,String nickname,String password) throws JsonProcessingException {
        String url = WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.KF_ADD);
        Map<String,String> maps = new HashMap<String,String>();
        maps.put("kf_account",account+"@gh_123456789");
        maps.put("nickname",nickname);
        maps.put("password", SecurityKit.md5(password));
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(maps);
        String json = WeixinBasicKit.sendJsonPost(url,content);
    }
}
