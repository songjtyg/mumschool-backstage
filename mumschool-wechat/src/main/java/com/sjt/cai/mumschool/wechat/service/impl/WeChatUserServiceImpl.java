package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeChatAccessToken2;
import com.sjt.cai.mumschool.wechat.dto.WeChatUser;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import com.sjt.cai.mumschool.wechat.service.WeChatUserService;
import com.sjt.cai.mumschool.wechat.util.WeChatBasicKit;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class WeChatUserServiceImpl implements WeChatUserService {
    @Override
    public WeChatUser queryByOpenid(String openid) throws IOException {
        String url = WeChatBasicKit.replaceAccessTokenUrl(WeChatFinalValue.USER);
        url = url.replace("OPENID",openid);
        String json = WeChatBasicKit.sendGet(url);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, WeChatUser.class);// todo 时间未能序列化
    }
    @Override
    public String queryOpenidByCode(String code) throws IOException {
        String url = WeChatFinalValue.AUTH_GET_OPPENID;
        url = url.replace("APPID", WeChatContext.getInstance().getAppId())
                .replace("SECRET", WeChatContext.getInstance().getAppSecurt())
                .replace("CODE",code);
        String json = WeChatBasicKit.sendGet(url);
        ObjectMapper mapper = new ObjectMapper();
        String openid = mapper.readValue(json, WeChatAccessToken2.class).getOpenid();
        return openid;
    }

}
