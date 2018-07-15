package com.sjt.cai.mumschool.wechat.service;

import com.sjt.cai.mumschool.wechat.dto.WeChatUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface WeChatUserService {
    WeChatUser queryByOpenid(String openid) throws IOException;

    String queryOpenidByCode(String code) throws IOException;
}
