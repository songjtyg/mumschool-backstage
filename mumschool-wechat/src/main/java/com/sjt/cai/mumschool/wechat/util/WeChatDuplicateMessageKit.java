package com.sjt.cai.mumschool.wechat.util;

import com.sjt.cai.mumschool.wechat.dto.WetChatDuplicateMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeChatDuplicateMessageKit {
    public static final List<WetChatDuplicateMessage> msgs = new ArrayList<WetChatDuplicateMessage>();

    public static boolean checkDuplicate(Map<String,String> msgMap){
        String fromUserName = msgMap.get("FromUserName");
        String createTime = msgMap.get("CreateTime");
        WetChatDuplicateMessage dm = new WetChatDuplicateMessage(fromUserName,createTime);
        if (msgs.contains(dm)){
            return true;
        }else{
            msgs.add(dm);
            return false;
        }
    }

    private static WetChatDuplicateMessage initDuplicateMessage(Map<String, String> msgMap) {
        String fromUserName = msgMap.get("FromUserName");
        String createTime = msgMap.get("CreateTime");
        WetChatDuplicateMessage dm = new WetChatDuplicateMessage(fromUserName,createTime);
        return dm;
    }

    public static String getRel(Map<String,String> msgMap){
        WetChatDuplicateMessage dm = initDuplicateMessage(msgMap);
        WetChatDuplicateMessage tdm = msgs.get(msgs.indexOf(dm));
        return tdm.getRel();
    }

    public static void setRel(Map<String,String> msgMap,String rel){
        WetChatDuplicateMessage dm = initDuplicateMessage(msgMap);
        WetChatDuplicateMessage tdm = msgs.get(msgs.indexOf(dm));
        tdm.setRel(rel);
    }

    /**
     * 消息清理
     */
    public static void clear(){
        WetChatDuplicateMessage dm = null;
        System.out.println("消息清理之前："+ msgs.size());
        for(int i = 0; i< msgs.size(); i++){
            dm  = msgs.get(i);
            if((((System.currentTimeMillis() - dm.getCurTime()))/1000)>30){
                msgs.remove(dm);
            }
        }
        System.out.println("消息清理之后："+ msgs.size());
    }
}
