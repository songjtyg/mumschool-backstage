package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeChatAccessToken;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import com.sjt.cai.mumschool.wechat.dto.WeChatTicket;
import com.sjt.cai.mumschool.wechat.service.WeChatRefreshService;
import com.sjt.cai.mumschool.wechat.util.WeChatBasicKit;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeChatRefreshServiceImpl implements WeChatRefreshService {
    @Override
    public void refreshAccessToken() throws IOException {
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
            //refreshAccessToken();//一旦发生错误，就会不断调用接口达上限。
        }
    }
    @Override
    public void refreshJsApiTicket() throws IOException {
        String url = WeChatFinalValue.JSAPI_TICKET_URL;

        url = url.replaceAll("ACCESS_TOKEN", WeChatContext.getInstance().getWeChatAccessToken().getAccess_token());
        String content = WeChatBasicKit.sendGet(url);
        if(WeChatBasicKit.checkRequestSucc(content)) {
            ObjectMapper mapper = new ObjectMapper();
            WeChatTicket weChatTicket = mapper.readValue(content, WeChatTicket.class);
            WeChatContext.getInstance().setWeChatTicket(weChatTicket);

            System.out.println(WeChatContext.getInstance().getWeChatAccessToken());
        } else {
            //refreshJsApiTicket();//一旦发生错误，就会不断调用接口达上限。
        }
    }
}
