package com.yjm.springbootdemo.utils;

import com.yjm.springbootdemo.SpringbootDemoApplication;
import com.yjm.springbootdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

//底层用junit  SpringJUnit4ClassRunner
@RunWith(SpringRunner.class)
//启动整个springboot工程，指定启动器和相关的配置文件
@SpringBootTest(classes={SpringbootDemoApplication.class})
class RedisOperatorTest {

    @Autowired
    RedisOperator redisOperator;

    @Test
    public void test(){
        System.out.println("save user---------------");
        User user = new User(12, "yjm", "15000", 33, new Date());
        String userStr= JsonUtils.obj2String(user);
        System.out.println(user);
        System.out.println(userStr);
        redisOperator.set("study:redis:32",userStr);

        System.out.println("get user---------------");
        String str=redisOperator.get("study:redis:32");
        User user1=JsonUtils.string2Obj(str, User.class);
        System.out.println(str);
        System.out.println(user1);
        System.out.println("end ---------------");
    }


}