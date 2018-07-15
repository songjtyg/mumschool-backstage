package com.sjt.cai.mumschool.wechat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.wechat.dto.WeChatAccessToken;
import com.sjt.cai.mumschool.wechat.dto.ModelMsgData;
import com.sjt.cai.mumschool.wechat.dto.WeChatTemplateMsg;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import com.sjt.cai.mumschool.wechat.media.WeChatMediaKit;
import com.sjt.cai.mumschool.wechat.util.WeChatMessageKit;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestInit {
    private String temp_access_token = "10_vCqCBY1DvPZ3Nua63CPllUjqbfTY2VBjcjjZZnn_1cn_y4kBd9lADlGAyqUGUHwTYsnUPYIVUOc8DqhNVsD59xE1R8cFCMVA88ptm5ALFCwmRZwjUbGiJJEzCkh9UMhRsffQCo3M-B46PCQnMYMhACABNB";

    @Before
    public void init(){
        WeChatAccessToken weChatAccessToken = new WeChatAccessToken();
        weChatAccessToken.setAccess_token(temp_access_token);
        WeChatContext.getInstance().setWeChatAccessToken(weChatAccessToken);
    }

    @Test
    public void testMsg(){
        try{
            Map<String,Object> maps = new HashMap<>();
            maps.put("aaa","111");
            maps.put("bbb","<b1>222</b1>");
            System.out.println(WeChatMessageKit.map2xml(maps));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPostMedia(){
        String mid = WeChatMediaKit.postMedia("d:/20180601.png","image");
        System.out.println(mid);
    }

    @Test
    public void testGetMedia() {
        String mid = "nDwKcYuGUH62UCsFmetNdyl8tu7ym2S62NXF9cl9UEWqcf-cHCj497bquMK35Mxg";
        WeChatMediaKit.getMedia(mid,new File("d:/123.png"));
    }

    /**
     * 测试发送模板消息
     */
    @Test
    public void testPostTemplateMsg() throws JsonProcessingException {
        WeChatTemplateMsg tm = new WeChatTemplateMsg();
        tm.setTouser("oqwbE0WIjFtKpWsb_M9WO0aIkYgw");
        tm.setTemplate_id("KgFHxciR0tDykTHHPcLm14Bl7pCW-NYggELyLEcS9L0");
        tm.setTopcolor("#ff0000");
        tm.setUrl("http://www.baidu.com");
        Map<String,Object> data = new HashMap<>();
        data.put("p1",new ModelMsgData("asd","#00ff00"));//中文乱码？
        tm.setData(data);
        WeChatMessageKit.postTemplateMsg(tm);
    }

}
