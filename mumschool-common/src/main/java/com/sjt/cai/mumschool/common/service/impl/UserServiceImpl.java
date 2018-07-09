package com.sjt.cai.mumschool.common.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.common.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.common.dto.AccessToken;
import com.sjt.cai.mumschool.common.dto.WUser;
import com.sjt.cai.mumschool.common.dto.WeixinContext;
import com.sjt.cai.mumschool.common.service.UserService;
import com.sjt.cai.mumschool.common.util.WeixinBasicKit;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public WUser queryByOpenId(String openId) throws IOException {
        String url = WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.USER);
        url = url.replace("OPENID",openId);
        String json = WeixinBasicKit.sendGet(url);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, WUser.class);

    }
    @Override
    public String queryOpenIdByCode(String code){
        String url = WeixinFinalValue.AUTH_GET_OID;
        url = url.replace("APPID", WeixinContext.getInstance().getAppId())
                .replace("SECRET",WeixinContext.getInstance().getAppSecurt())
                .replace("CODE",code);
        String json =WeixinBasicKit.sendGet(url);
        ObjectMapper mapper = new ObjectMapper();
        String openId = "";// mapper.readValue(json).;16章22分，jackson取得openId
        return openId;
    }

}
