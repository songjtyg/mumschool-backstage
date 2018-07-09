package com.sjt.cai.mumschool.web.component;

import com.sjt.cai.mumschool.common.dto.WeixinContext;
import com.sjt.cai.mumschool.common.service.impl.RefreshAccessTokenTaskServiceImpl;
import com.sjt.cai.mumschool.web.component.WeixinContextProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 启动时执行
 * 这里通过设定value的值来指定执行顺序
 */
@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {
    @Autowired
    private WeixinContextProperties weixinContextProperties;
    @Autowired
    private RefreshAccessTokenTaskServiceImpl refreshAccessTokenTaskService;
    @Override
    public void run(ApplicationArguments var1) throws Exception{
        Map<String,String> conf = weixinContextProperties.getConf();
        WeixinContext.getInstance().setAppId(conf.get("appId"));
        WeixinContext.getInstance().setAppSecurt(conf.get("appsecret"));
        WeixinContext.getInstance().setBaseUrl(conf.get("base_url"));
        WeixinContext.getInstance().setToken(conf.get("weixin_token"));

        System.out.println("系统初始化!");
        refreshAccessTokenTaskService.refreshToken();
    }

}