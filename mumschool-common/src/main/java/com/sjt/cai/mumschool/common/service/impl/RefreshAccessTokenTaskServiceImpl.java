package com.sjt.cai.mumschool.common.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.common.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.common.dto.AccessToken;
import com.sjt.cai.mumschool.common.dto.WeixinContext;
import com.sjt.cai.mumschool.common.service.RefreshAccessTokenTaskService;
import com.sjt.cai.mumschool.common.util.WeixinBasicKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RefreshAccessTokenTaskServiceImpl implements RefreshAccessTokenTaskService {
    @Override
    public void  refreshToken() throws IOException {
        String url = WeixinFinalValue.ACCESS_TOKEN_URL;

        url = url.replaceAll("APPID", WeixinContext.getInstance().getAppId());
        url = url.replaceAll("APPSECRET", WeixinContext.getInstance().getAppSecurt());
        String content = WeixinBasicKit.sendGet(url);
        if(WeixinBasicKit.checkRequestSucc(content)) {
            ObjectMapper mapper = new ObjectMapper();
            AccessToken accessToken = mapper.readValue(content, AccessToken.class);
            WeixinContext.getInstance().setAccessToken(accessToken);

            System.out.println(WeixinContext.getInstance().getAccessToken());
        } else {
            //refreshToken();//一旦发生错误，就会不断调用接口达上限。
        }
    }
}
