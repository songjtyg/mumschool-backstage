package com.sjt.cai.mumschool.common.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface KfService {
    void add(String account, String nickname, String password) throws JsonProcessingException;
}
