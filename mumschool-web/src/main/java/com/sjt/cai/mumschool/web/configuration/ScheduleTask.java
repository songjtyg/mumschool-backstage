package com.sjt.cai.mumschool.web.configuration;

import com.sjt.cai.mumschool.wechat.service.impl.WeChatRefreshServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Configuration
@Component
@EnableScheduling // 该注解必须要加
public class ScheduleTask {
    @Autowired
    private WeChatRefreshServiceImpl refreshAccessTokenTaskService;
    public void scheduleFreshccessToken() throws IOException {
        System.err.println("定时任务执行");
        refreshAccessTokenTaskService.refreshAccessToken();
        refreshAccessTokenTaskService.refreshJsApiTicket();
    }
}