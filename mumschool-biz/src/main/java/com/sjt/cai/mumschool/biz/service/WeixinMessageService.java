package com.sjt.cai.mumschool.biz.service;

import java.io.IOException;
import java.util.Map;

public interface WeixinMessageService {
    String handlerMsg(Map<String, String> msgMap) throws IOException;
}
