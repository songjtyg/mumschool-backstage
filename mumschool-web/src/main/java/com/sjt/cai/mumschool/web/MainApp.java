package com.sjt.cai.mumschool.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

/**
 * Created by songjt on 2018/03/24.
 */
@SpringBootApplication(excludeName = "*Service",
        scanBasePackages = {"com.sjt.cai",
        "com.sjt.cai.mumschool.wechat.service.impl",
        "com.sjt.cai.mumschool.biz.service.impl"})
public class MainApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(MainApp.class, args);
    }

}