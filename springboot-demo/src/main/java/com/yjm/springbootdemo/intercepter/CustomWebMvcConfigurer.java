package com.yjm.springbootdemo.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {



//    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * addPathPatterns添加拦截规则
         * 增加拦截器，可以增加多个拦截器
         */
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/api2/*/**");
        registry.addInterceptor(new TwoIntercepter()).addPathPatterns("/api2/*/**");

        //.excludePathPatterns("/api2/xxx/**"); //拦截全部 /*/*/**

        //调用父类的拦截器，默认生成
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
