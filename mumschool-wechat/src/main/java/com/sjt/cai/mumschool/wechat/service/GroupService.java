package com.sjt.cai.mumschool.wechat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.wechat.dto.WGroup;

import java.io.IOException;
import java.util.List;

public interface GroupService {
    void add(WGroup group) throws JsonProcessingException;
    List<WGroup> queryAll() throws IOException;
    WGroup queryUserGroup(String openid) throws IOException;
    void updateGroupName(int gid,String name);
    void moveUserToGroup(String openid,int gid);
    void moveUsersToGroup(List<String> openids,int gid);
    void deleteGroup(int gid);
}
