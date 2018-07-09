package com.sjt.cai.mumschool.common.util;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.common.dto.WeixinContext;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.konghao.basic.util.JsonUtil;
//import org.konghao.basic.util.PropertiesUtil;
//import org.konghao.weixin.web.servlet.WeixinContext;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;

public class WeixinBasicKit {

	public static String replaceAccessTokenUrl(String url) {
		return url.replace("ACCESS_TOKEN", WeixinContext.getInstance().getAccessToken().getAccess_token());
	}
	
	/**
	 * 检查请求是否成功
	 * @return
	 */
	public static boolean checkRequestSucc(String content) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jn = mapper.readTree(content);

			if(!jn.has("errcode")) return true;
			if(jn.get("errcode").asInt()==0) return true;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int getRequestCode(String content) {
		try {
			//JsonNode jn = JsonUtil.getMapper().readTree(content);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jn = mapper.readTree(content);
			if(jn.has("errcode")) return jn.get("errcode").asInt();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static String getRequestMsg(String content) {
		try {
			//JsonNode jn = JsonUtil.getMapper().readTree(content);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jn = mapper.readTree(content);
			if(jn.has("errcode")) return jn.get("errmsg").asText();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sendGet(String url) {
		HttpGet get = null;
		CloseableHttpResponse resp = null;
		CloseableHttpClient client = null;
		try {
			client = HttpClients.createDefault();
			get = new HttpGet(url);
			get.addHeader("Content-type","application/json;charset=UTF-8");
			resp = client.execute(get);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				HttpEntity entity = resp.getEntity();
				String content = EntityUtils.toString(entity,"UTF-8");
				return content;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resp!=null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(client!=null) client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String sendJsonPost(String url,String content) {
		return sendPost(url, content, "application/json");
	}
	
	public static String sendXmlPost(String url,String content) {
		return sendPost(url, content, "application/xml");
	}
	
	public static String sendPost(String url,String content,String type) {
		CloseableHttpClient client = null;
		CloseableHttpResponse resp = null;
		try {
			client = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-type",type);
			StringEntity entity = new StringEntity(content, ContentType.create(type, "UTF-8"));
			post.setEntity(entity);
			resp = client.execute(post);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				String str = EntityUtils.toString(resp.getEntity());
				return str;
			}
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(client!=null) client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if(resp!=null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
