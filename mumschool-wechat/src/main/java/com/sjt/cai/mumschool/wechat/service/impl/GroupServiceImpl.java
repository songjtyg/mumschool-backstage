package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeixinContext;
import com.sjt.cai.mumschool.wechat.service.GroupService;
import com.sjt.cai.mumschool.wechat.dto.WGroup;
import com.sjt.cai.mumschool.wechat.util.WeixinBasicKit;
import com.sjt.cai.mumschool.wechat.util.WeixinKit;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl implements GroupService {

    @Override
    public void add(WGroup group) throws JsonProcessingException {
        String url = WeixinFinalValue.ADD_GROUP;
        url = url.replace("ACCESS_TOKEN", WeixinContext.getInstance().getAccessToken().getAccess_token());
        Map<String,WGroup> map = new HashMap<>();
        map.put("group",group);
        ObjectMapper mapper = new ObjectMapper();
        String json=  mapper.writeValueAsString(group);
        String con = WeixinKit.postReq(url,json,"application/json");
        System.out.println(con);
    }

    @Override
    public List<WGroup> queryAll() throws IOException {
        String url = WeixinFinalValue.QUERY_ALL_GROUP;
        url = url.replace("ACCESS_TOKEN",WeixinContext.getInstance().getAccessToken().getAccess_token());
        String json = WeixinBasicKit.sendGet(url);

        ObjectMapper mapper = new ObjectMapper();
        //todo ??https://blog.csdn.net/zhuyijian135757/article/details/38269715
        //08章 35分

        System.out.println(json);
        return null;
    }

    @Override
    public WGroup queryUserGroup(String openid) throws IOException {
        List<WGroup> wgs = queryAll();
        String url = WeixinFinalValue.QUERY_USER_GROUP;
        url = url.replace("ACCESS_TOKEN",WeixinContext.getInstance().getAccessToken().getAccess_token());
        Map<String,String> map = new HashMap<>();
        map.put("openId",openid);
        String con = WeixinBasicKit.sendPost(url,"??????????????????","application/json");
        System.out.println(con);
        //todo 08章 46分
        return null;
    }

    @Override
    public void updateGroupName(int gid, String name) {

    }

    @Override
    public void moveUserToGroup(String openid, int gid) {

    }

    @Override
    public void moveUsersToGroup(List<String> openIds, int gid) {

    }

    @Override
    public void deleteGroup(int gid) {

    }
}
