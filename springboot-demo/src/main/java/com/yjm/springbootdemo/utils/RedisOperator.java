package com.yjm.springbootdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 将原生redis方法，封装成一个类，方便自己操作调用
 * redis操作工具类
 */
@Component
public class RedisOperator {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置key-value到redis
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 返回需要强制转化为String，因为返回是一个String
     */
    public String get(String key){
        return (String)redisTemplate.opsForValue().get(key);
    }



}
