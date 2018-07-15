package com.sjt.cai.mumschool.wechat.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WeChatKit {

    /**
     * 发送模板消息
     * @param
     * @return
     */
    public static String postReq(String url,String data,String type){
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-type",type);
            StringEntity entity = new StringEntity(data, ContentType.create(type,"UTF-8"));
            post.setEntity(entity);
            resp = client.execute(post);
            int statusCode = resp.getStatusLine().getStatusCode();
            if ( statusCode >=200 && statusCode<300){
                String str = EntityUtils.toString(resp.getEntity());
                System.out.println(str);
                return str;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(client != null) client.close();
            }catch(IOException el){
                el.printStackTrace();
            }
            try{
                if(resp != null) resp.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
