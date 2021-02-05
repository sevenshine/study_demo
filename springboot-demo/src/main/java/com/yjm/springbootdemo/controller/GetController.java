package com.yjm.springbootdemo.controller;

import com.yjm.springbootdemo.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Http协议测试demo：get & post
 *
 * 测试http协议的get请求
 */
@RestController
public class GetController {

    private Map<String, Object> params = new HashMap<>();

    /**
     * 测试restful协议，从路径中获取字段
     * URL 中的 {xxx} 占位符可以通过 @PathVariable("xxx") 绑定到操作方法的入参中
     * 请求：localhost:8080/hello/test
     * @param cityId
     * @param userId
     * @return
     */
    @GetMapping(path = "/{city_id}/{user_id}")
    public Object findUser(@PathVariable("city_id") String cityId,@PathVariable("user_id") String userId){
        params.put("cityId", cityId);
        params.put("userId", userId);

        System.out.println(params);
        return params;
    }

    /**
     * 测试GetMapping
     * 获取路径中带的参数，参数类型为要统一（int）
     * 请求：http://localhost:8080/v1/page_user1?from=12&size=11
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value="/v1/test")
    public Object pageUser(int  from, int size ){
        params.clear();
        params.put("from", from);
        params.put("size", size);

        return params;
    }

    /**
     * 功能描述：bean对象传参
     * 注意：1、body指定row-》json（http头为 content-type为application/json charset=utf-8）
     * 		2、使用body传输数据，post协议才有body数据，所以需要post传输
     * @param user
     * @return
     */
    @PostMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user", user);
        return params;
    }

}
