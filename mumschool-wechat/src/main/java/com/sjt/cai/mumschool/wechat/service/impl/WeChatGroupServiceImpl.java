package com.sjt.cai.mumschool.wechat.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import com.sjt.cai.mumschool.wechat.service.WeChatGroupService;
import com.sjt.cai.mumschool.wechat.dto.WeChatGroup;
import com.sjt.cai.mumschool.wechat.util.WeChatBasicKit;
import com.sjt.cai.mumschool.wechat.util.WeChatKit;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeChatGroupServiceImpl implements WeChatGroupService {

    @Override
    public void add(WeChatGroup group) throws JsonProcessingException {
        String url = WeChatFinalValue.ADD_GROUP;
        url = url.replace("ACCESS_TOKEN", WeChatContext.getInstance().getWeChatAccessToken().getAccess_token());
        Map<String,WeChatGroup> map = new HashMap<>();
        map.put("group",group);
        ObjectMapper mapper = new ObjectMapper();
        String json=  mapper.writeValueAsString(group);
        String con = WeChatKit.postReq(url,json,"application/json");
        System.out.println(con);
    }

    @Override
    public List<WeChatGroup> queryAll() throws IOException {
        String url = WeChatFinalValue.QUERY_ALL_GROUP;
        url = url.replace("ACCESS_TOKEN", WeChatContext.getInstance().getWeChatAccessToken().getAccess_token());
        String json = WeChatBasicKit.sendGet(url);

        ObjectMapper mapper = new ObjectMapper();
        //todo ??https://blog.csdn.net/zhuyijian135757/article/details/38269715
        //08章 35分

        System.out.println(json);
        return null;
    }

    @Override
    public WeChatGroup queryUserGroup(String openid) throws IOException {
        List<WeChatGroup> wgs = queryAll();
        String url = WeChatFinalValue.QUERY_USER_GROUP;
        url = url.replace("ACCESS_TOKEN", WeChatContext.getInstance().getWeChatAccessToken().getAccess_token());
        Map<String,String> map = new HashMap<>();
        map.put("openid",openid);
        String con = WeChatBasicKit.sendPost(url,"??????????????????","application/json");
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
    public void moveUsersToGroup(List<String> openids, int gid) {

    }

    @Override
    public void deleteGroup(int gid) {

    }
}
