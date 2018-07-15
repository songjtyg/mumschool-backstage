package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.service.WeChatWqrService;
import com.sjt.cai.mumschool.wechat.util.WeChatBasicKit;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeChatWqrServiceImpl implements WeChatWqrService {

    @Override
    public String loadTicketByBaseQr(int snum) {
        return null;
    }

    @Override
    public String loadTicketByTempQr(int snum) {
        try{
            String url = WeChatBasicKit.replaceAccessTokenUrl(WeChatFinalValue.QR_GET);
            String json = "{\"expire_seconds\":180,\"action_name\":\"QR_SCENE";
            String rjson = WeChatBasicKit.sendJsonPost(url,json);
            if (WeChatBasicKit.checkRequestSucc(json)) {
                ObjectMapper mapper =  new ObjectMapper();
                JsonNode node = mapper.readTree(rjson);
                return  node.get("ticket").asText();

            }
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
