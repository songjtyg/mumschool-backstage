package com.sjt.cai.mumschool.wechat.service;

import java.io.IOException;


public interface RefreshAccessTokenTaskService {
    void  refreshToken() throws IOException;
}
