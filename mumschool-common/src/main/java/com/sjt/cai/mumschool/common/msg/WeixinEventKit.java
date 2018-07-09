package com.sjt.cai.mumschool.common.msg;

import com.sjt.cai.mumschool.common.service.UserService;
import com.sjt.cai.mumschool.entity.po.WeixinMenuPO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public class WeixinEventKit {
    @Autowired
    private UserService userService;
    public static String handlerClickEvent(Map<String, String> msgMap,WeixinMenuPO wm ) throws IOException {
        if (wm != null && wm.getResponseType() == 1){
            Map<String,Object> map = MessageCreateKit.createTextMsg(msgMap,wm.getContent());
            return MessageKit.map2xml(map);
        }
        return null;
    }

    public static String extractOpenId(Map<String, String> msgMap) {
        String openId = msgMap.get("FromUserName");
        return openId;
    }
}
