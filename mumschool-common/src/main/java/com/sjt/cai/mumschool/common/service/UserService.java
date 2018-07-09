package com.sjt.cai.mumschool.common.service;

import com.sjt.cai.mumschool.common.dto.WUser;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface UserService {
    WUser queryByOpenId(String openId) throws IOException;

    String queryOpenIdByCode(String code);
}
