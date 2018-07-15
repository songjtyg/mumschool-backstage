package com.sjt.cai.mumschool.wechat.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeChatTemplateMsg;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;

public class WeChatMessageKit {
    private static Map<String,String> replyMsgs = new HashMap<>();
    static{
        replyMsgs.put("hello","hello！");
        replyMsgs.put("您好","您好！");
        replyMsgs.put("other","欢迎来到妈妈校园，有问题请联系客服！");
    }

    /**
     * 转换xml消息到Map对象
     * @param req
     * @return
     * @throws IOException
     */
    public static Map<String,String> reqMsg2Map(HttpServletRequest req) throws IOException{
        String xml = req2xml(req);
        try {
            Map<String,String> maps = new HashMap<>();
            Document document = DocumentHelper.parseText(xml);
            Element root = document.getRootElement();
            List<Element> eles = root.elements();
            for (Element e : eles){
                maps.put(e.getName(),e.getTextTrim());
            }
            return maps;
        }catch(DocumentException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从request提取xml消息
     * @param req
     * @return
     * @throws IOException
     */
    private static String req2xml(HttpServletRequest req) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String str = null;
        StringBuffer sb = new StringBuffer();
        while((str = br.readLine())!=null){
            sb.append(str);
        }
        return sb.toString();
    }

    public static String hanlderCommonMsg(Map<String, String> msgMap) throws IOException {
        return WeChatMessageKit.map2xml(WeChatMessageKit.createTextMsg(msgMap,"我收到了消息"));

    }

    public static String imageTypeHandler(Map<String, String> msgMap, String mediaId) throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("ToUserName",msgMap.get("FromUserName"));
        map.put("FromUserName",msgMap.get("ToUserName"));
        map.put("CreateTime",String.valueOf(new Date().getTime()));
        map.put("MsgType","image");
        map.put("Image","<MediaId>"+mediaId+"</MediaId>");
        return map2xml(map);
    }

    public static String textTypeHandler(Map<String,String> msgMap) throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("ToUserName",msgMap.get("FromUserName"));
        map.put("FromUserName",msgMap.get("ToUserName"));
        map.put("CreateTime",String.valueOf(new Date().getTime()));
        map.put("MsgType","text");
        String replyContent = "你请求的消息内容格式不正确";
        String con = msgMap.get("Content");
        if(replyMsgs.containsKey(con)){
            replyContent = replyMsgs.get(con);
        }
        map.put("Content",replyContent);
        return map2xml(map);

    }

    /**
     * 转换Map对象到xml消息
     * @param map
     * @return
     * @throws IOException
     */
    public static String map2xml(Map<String,Object> map) throws IOException {
        Document d = DocumentHelper.createDocument();
        Element root = d.addElement("xml");
        Set<String> keys = map.keySet();
        for(String key:keys){
            Object o = map.get(key);
            if (o instanceof String) {
                String t = (String)o;
                if(t.indexOf("<a")>=0){
                    root.addElement(key).addCDATA(t);
                }else {
                    root.addElement(key).addText((String) o);
                }
            }else{
                //todo
            }
        }
        StringWriter sw = new StringWriter();
        //解决不认“添加的字符串中带节点”的问题
        XMLWriter xw = new XMLWriter(sw);
        xw.setEscapeText(false);
        xw.write(d);

        d.write(sw);
        return sw.toString();
    }

    /**
     * 发送模板消息
     * @param tm
     * @return
     */
    public static String postTemplateMsg(WeChatTemplateMsg tm) throws JsonProcessingException {
        String url = WeChatFinalValue.SEND_TEMPLATE_MSG;
        url = url.replace("ACCESS_TOKEN", WeChatContext.getInstance().getWeChatAccessToken().getAccess_token());

        ObjectMapper mapper = new ObjectMapper();
        String json=  mapper.writeValueAsString(tm);
        return WeChatKit.postReq(url,json,"application/json");
    }

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
