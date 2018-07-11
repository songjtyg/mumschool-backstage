package com.sjt.cai.mumschool.wechat.service;

import com.sjt.cai.mumschool.wechat.dto.WUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface UserService {
    WUser queryByOpenId(String openId) throws IOException;

    String queryOpenIdByCode(String code);
}
