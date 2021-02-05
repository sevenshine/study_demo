package com.yjm.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Spring的一个组件
 */
@SpringBootApplication
@ServletComponentScan
//@MapperScan("com.yjm.springbootdemo")
@MapperScan("com.yjm.springbootdemo.*.mapper")
@EnableAsync   //开启异步任务
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
