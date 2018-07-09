package com.sjt.cai.mumschool.common.msg;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MessageCreateKit {
    public static Map<String, Object> createTextMsg(Map<String, String> msgMap, String content) {
        Map<String,Object> tm = new HashMap<>();
        tm.put("ToUserName",msgMap.get("FromUserName"));
        tm.put("FromUserName",msgMap.get("ToUserName"));
        tm.put("CreateTime",String.valueOf(System.currentTimeMillis()));
        tm.put("MsgType","text");
        tm.put("Content",content);
        return tm;
    }
}
