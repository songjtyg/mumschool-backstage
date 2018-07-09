package com.sjt.cai.mumschool.common.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.common.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.common.service.WqrService;
import com.sjt.cai.mumschool.common.util.WeixinBasicKit;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WqrServiceImpl implements WqrService {

    @Override
    public String loadTicketByBaseQr(int snum) {
        return null;
    }

    @Override
    public String loadTicketByTempQr(int snum) {
        try{
            String url = WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.QR_GET);
            String json = "{\"expire_seconds\":180,\"action_name\":\"QR_SCENE";
            String rjson = WeixinBasicKit.sendJsonPost(url,json);
            if (WeixinBasicKit.checkRequestSucc(json)) {
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
