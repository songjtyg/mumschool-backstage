package com.sjt.cai.mumschool.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

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
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainApp.class);

    }
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {

                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");

                container.addErrorPages(error404Page);
            }
        };
    }
}