package com.sjt.cai.mumschool.wechat.service;

import java.io.IOException;


public interface WeChatRefreshAccessTokenTaskService {
    void  refreshToken() throws IOException;
}
