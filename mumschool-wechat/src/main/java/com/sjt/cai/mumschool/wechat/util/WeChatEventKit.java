package com.sjt.cai.mumschool.wechat.util;

import com.sjt.cai.mumschool.wechat.service.WeChatUserService;
import com.sjt.cai.mumschool.entity.po.WeixinMenuPO;
import com.sjt.cai.mumschool.wechat.util.WeChatMessageKit;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public class WeChatEventKit {
    @Autowired
    private WeChatUserService weChatUserService;
    public static String handlerClickEvent(Map<String, String> msgMap,WeixinMenuPO wm ) throws IOException {
        if (wm != null && wm.getResponseType() == 1){
            Map<String,Object> map = WeChatMessageKit.createTextMsg(msgMap,wm.getContent());
            return WeChatMessageKit.map2xml(map);
        }
        return null;
    }

    public static String extractOpenid(Map<String, String> msgMap) {
        return msgMap.get("FromUserName");
    }
}
