package com.sjt.cai.mumschool.wechat.util;

import com.sjt.cai.mumschool.wechat.service.WeChatUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public class WeChatEventKit {
    @Autowired
    private WeChatUserService weChatUserService;
    public static String handlerClickEvent(Map<String, String> msgMap,String content ) throws IOException {
        if ( content != null ){
            Map<String,Object> map = WeChatMessageKit.createTextMsg(msgMap,content);
            return WeChatMessageKit.map2xml(map);
        }
        return null;
    }

    public static String extractOpenid(Map<String, String> msgMap) {
        return msgMap.get("FromUserName");
    }
}
