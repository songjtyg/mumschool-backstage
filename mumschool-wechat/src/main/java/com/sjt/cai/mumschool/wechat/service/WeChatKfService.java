package com.sjt.cai.mumschool.wechat.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeChatKfService {
    void add(String account, String nickname, String password) throws JsonProcessingException;
}
