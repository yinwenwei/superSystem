package com.srqy.supersystem.config;

import com.srqy.supersystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yww
 * @CreateTime: 2020/5/21
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    //配置拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        //拦截.do和.html请求
        registration.addPathPatterns("/**/*.do","/**/*.html");
        List<String> list = new ArrayList<String>();
        //登录放行
        list.add("/sys/login.html");
        list.add("/sys/login.do");
        registration.excludePathPatterns(list);
        super.addInterceptors(registry);
    }

    //配置静态文件访问
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        super.addResourceHandlers(registry);
    }
}