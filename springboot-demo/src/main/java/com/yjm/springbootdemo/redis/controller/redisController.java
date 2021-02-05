package com.yjm.springbootdemo.redis.controller;

import com.yjm.springbootdemo.domain.User;
import com.yjm.springbootdemo.domain.JsonData;
import com.yjm.springbootdemo.utils.JsonUtils;
import com.yjm.springbootdemo.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;



@RestController
@RequestMapping("redis")
public class redisController {

    /**
     * redis封装工具类
     */
    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisOperator redisOperator;

    @PostMapping("add")
    public Object add(){
        System.out.println("redis add----------------");
        /**
         * 方式一：原生redis
         * redisTemplate.opsForValue()返回ValueOperations<K, V>
         * ValueOperations包含了各类操作
         *
         */
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("name", "yjm");
        redisTemplate.opsForValue().set("name1","yjm1");

        /**
         * 方式二：使用封装的方法来进行redis操作，这个是通用方法
         */
        redisOperator.set("name2","yjm2");

        return JsonData.buildSuccess("success");
    }

    @PostMapping("get")
    public Object Get(){
        String value1=redisTemplate.opsForValue().get("name");
        String value2=redisOperator.get("name2");

        return JsonData.buildSuccess(value1+" "+value2);
    }

    @PostMapping("save_user")
    public Object SaveUser(){
        System.out.println("save user---------------");
        User user = new User(11, "yjm", "15000", 33, new Date());
        System.out.println(user);
        String userStr= JsonUtils.obj2String(user);
        System.out.println(userStr);

        //redis命名规范，通过:来进行划分项目名和系统模块
        boolean flag=redisOperator.set("study:redis:12",userStr);
        return JsonData.buildSuccess(flag);
    }

    @PostMapping("find_user")
    public Object FindUser(){
        System.out.println("find user---------------");
        String str=redisOperator.get("study:redis:12");

        /**
         * String转对象--》Json对象，响应返回的时候需要返回一个Json对象，所以需要转成Json对象进行对象返回
         */
        User user =JsonUtils.string2Obj(str, User.class);
        System.out.println(str);
        System.out.println(user);


        return JsonData.buildSuccess(user);
    }


}
