package com.yjm.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * hello world测试：spring boot基础代码测试
 *
 * 等价于@Controller+@ResponseBody,返回json
 */
//@RestController
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @PostMapping("hello")
    public String hello(){
        return "hello world";
    }
}
