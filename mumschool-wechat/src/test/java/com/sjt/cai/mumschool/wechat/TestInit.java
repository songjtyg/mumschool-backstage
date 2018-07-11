package com.sjt.cai.mumschool.wechat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.wechat.dto.AccessToken;
import com.sjt.cai.mumschool.wechat.dto.ModelMsgData;
import com.sjt.cai.mumschool.wechat.dto.TemplateMsg;
import com.sjt.cai.mumschool.wechat.dto.WeixinContext;
import com.sjt.cai.mumschool.wechat.media.MediaKit;
import com.sjt.cai.mumschool.wechat.msg.MessageKit;
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
        AccessToken accessToken = new AccessToken();
        accessToken.setAccess_token(temp_access_token);
        WeixinContext.getInstance().setAccessToken(accessToken);
    }

    @Test
    public void testMsg(){
        try{
            Map<String,Object> maps = new HashMap<>();
            maps.put("aaa","111");
            maps.put("bbb","<b1>222</b1>");
            System.out.println(MessageKit.map2xml(maps));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testPostMedia(){
        String mid = MediaKit.postMedia("d:/20180601.png","image");
        System.out.println(mid);
    }

    @Test
    public void testGetMedia() {
        String mid = "nDwKcYuGUH62UCsFmetNdyl8tu7ym2S62NXF9cl9UEWqcf-cHCj497bquMK35Mxg";
        MediaKit.getMedia(mid,new File("d:/123.png"));
    }

    /**
     * 测试发送模板消息
     */
    @Test
    public void testPostTemplateMsg() throws JsonProcessingException {
        TemplateMsg tm = new TemplateMsg();
        tm.setTouser("oqwbE0WIjFtKpWsb_M9WO0aIkYgw");
        tm.setTemplate_id("KgFHxciR0tDykTHHPcLm14Bl7pCW-NYggELyLEcS9L0");
        tm.setTopcolor("#ff0000");
        tm.setUrl("http://www.baidu.com");
        Map<String,Object> data = new HashMap<>();
        data.put("p1",new ModelMsgData("asd","#00ff00"));//中文乱码？
        tm.setData(data);
        MessageKit.postTemplateMsg(tm);
    }

}
