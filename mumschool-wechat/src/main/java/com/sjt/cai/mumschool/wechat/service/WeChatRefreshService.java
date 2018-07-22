package com.sjt.cai.mumschool.wechat.service;

import java.io.IOException;


public interface WeChatRefreshService {
    void refreshAccessToken() throws IOException;

    void refreshJsApiTicket() throws IOException;
}
