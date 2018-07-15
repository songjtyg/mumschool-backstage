package com.sjt.cai.mumschool.web.configuration;

import com.sjt.cai.mumschool.web.interceptor.AuthenticateInterceptor;
import com.sjt.cai.mumschool.web.interceptor.WeixinAuthenticateInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 李理
 * @since 2018/1/16
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public AuthenticateInterceptor authenticateInterceptor(){
        return new AuthenticateInterceptor();
    }
    @Bean
    public WeixinAuthenticateInterceptor weixinAuthenticateInterceptor(){return new WeixinAuthenticateInterceptor();};
    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(weixinAuthenticateInterceptor()).addPathPatterns("/**").excludePathPatterns(
                "/api/userManagementProxy/list",
                "/api/workingCalendar/list");
//        registry.addInterceptor(authenticateInterceptor()).addPathPatterns("/**").excludePathPatterns(
//                "/api/userManagementProxy/list",
//                "/api/workingCalendar/list");
        super.addInterceptors(registry);
    }

    /**
     * 跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
        super.addCorsMappings(registry);
    }


}
