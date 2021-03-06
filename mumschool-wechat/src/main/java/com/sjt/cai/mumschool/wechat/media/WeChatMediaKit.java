package com.sjt.cai.mumschool.wechat.media;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import com.sjt.cai.mumschool.wechat.dto.WeChatMedia;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WeChatMediaKit {
    public static String postMedia(String path,String type )  {
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;
        try{
            client = HttpClients.createDefault();
            String url = WeChatFinalValue.POST_MEDIA;
            url = url.replace("ACCESS_TOKEN", WeChatContext.getInstance().getWeChatAccessToken().getAccess_token());
            url = url.replace("TYPE",type);
            HttpPost post = new HttpPost(url);
            FileBody fb = new FileBody(new File(path));
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("media",fb).build();
            post.setEntity(reqEntity);
            resp = client.execute(post);
            int sc = resp.getStatusLine().getStatusCode();
            if(sc>=200 && sc <300){
                String json = EntityUtils.toString(resp.getEntity());
                ObjectMapper objectMapper =  new ObjectMapper();
                WeChatMedia wm = objectMapper.readValue(json,WeChatMedia.class);
                //WeChatMedia wm = (WeChatMedia)JsonUtil.getInstance().json2obj(json, WeChatMedia.class);
                return wm.getMedia_id();
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(client != null)
                    client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(resp != null)
                    resp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void getMedia(String mediaId,File f){
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;
        try{
            client = HttpClients.createDefault();
            String url = WeChatFinalValue.GET_MEDIA;
            url = url.replace("ACCESS_TOKEN", WeChatContext.getInstance().getWeChatAccessToken().getAccess_token());
            url = url.replace("MEDIA_ID",mediaId);
            HttpGet get = new HttpGet(url);
            resp = client.execute(get);
            int sc = resp.getStatusLine().getStatusCode();
            if(sc>=200 && sc <300){
                InputStream is = resp.getEntity().getContent();
                FileUtils.copyInputStreamToFile(is,f);
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(client != null)
                    client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(resp != null)
                    resp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
