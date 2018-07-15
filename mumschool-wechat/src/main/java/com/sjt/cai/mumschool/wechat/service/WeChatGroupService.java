package com.sjt.cai.mumschool.wechat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.wechat.dto.WeChatGroup;

import java.io.IOException;
import java.util.List;

public interface WeChatGroupService {
    void add(WeChatGroup group) throws JsonProcessingException;
    List<WeChatGroup> queryAll() throws IOException;
    WeChatGroup queryUserGroup(String openid) throws IOException;
    void updateGroupName(int gid,String name);
    void moveUserToGroup(String openid,int gid);
    void moveUsersToGroup(List<String> openids,int gid);
    void deleteGroup(int gid);
}
