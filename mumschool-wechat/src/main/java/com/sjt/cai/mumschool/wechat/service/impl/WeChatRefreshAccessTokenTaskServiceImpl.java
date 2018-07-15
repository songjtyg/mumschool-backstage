package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeChatAccessToken;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import com.sjt.cai.mumschool.wechat.service.WeChatRefreshAccessTokenTaskService;
import com.sjt.cai.mumschool.wechat.util.WeChatBasicKit;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeChatRefreshAccessTokenTaskServiceImpl implements WeChatRefreshAccessTokenTaskService {
    @Override
    public void  refreshToken() throws IOException {
        String url = WeChatFinalValue.ACCESS_TOKEN_URL;

        url = url.replaceAll("APPID", WeChatContext.getInstance().getAppId());
        url = url.replaceAll("APPSECRET", WeChatContext.getInstance().getAppSecurt());
        String content = WeChatBasicKit.sendGet(url);
        if(WeChatBasicKit.checkRequestSucc(content)) {
            ObjectMapper mapper = new ObjectMapper();
            WeChatAccessToken weChatAccessToken = mapper.readValue(content, WeChatAccessToken.class);
            WeChatContext.getInstance().setWeChatAccessToken(weChatAccessToken);

            System.out.println(WeChatContext.getInstance().getWeChatAccessToken());
        } else {
            //refreshToken();//一旦发生错误，就会不断调用接口达上限。
        }
    }
}
