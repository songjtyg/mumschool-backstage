package com.sjt.cai.mumschool.common.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjt.cai.mumschool.common.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.common.dto.AccessToken;
import com.sjt.cai.mumschool.common.dto.WeixinContext;
import com.sjt.cai.mumschool.common.util.WeixinBasicKit;
import org.springframework.stereotype.Component;

import java.io.IOException;


public interface RefreshAccessTokenTaskService {
    void  refreshToken() throws IOException;
}
