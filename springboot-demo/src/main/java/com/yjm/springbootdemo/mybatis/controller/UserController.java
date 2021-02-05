package com.yjm.springbootdemo.mybatis.controller;

import com.yjm.springbootdemo.domain.JsonData;
import com.yjm.springbootdemo.mybatis.domain.UserT;
import com.yjm.springbootdemo.mybatis.mapper.UserMapper;
import com.yjm.springbootdemo.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * controller api接口
 */
@RestController
@RequestMapping("/test/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("add")
    public Object add(){
        System.out.println("controller---add---------");
        UserT user=new UserT();
        user.setAge(11);
        user.setCreateTime(new Date());
        user.setName("yjm");
        user.setPhone("10010000");

        int id = userService.add(user);

        return JsonData.buildSuccess(id);
    }

    /**
     * Mapper直接返回
     * public static JsonData buildSuccess(Object data)
     * 通过Object返回，返回对象的list：List<UserP> 这个和HZSL里面的总体返回原则等同
     *
     * 设计的返回，是直接响应应答码+具体的返回报文data
     */
    @PostMapping("findall")
    public Object findAll(){
        System.out.println("findall------------");
        return JsonData.buildSuccess(userMapper.getAll());
    }

    @PostMapping("addacc")
    public Object addAcc(){

        int id = userService.addAccount();
        return JsonData.buildSuccess(id);
    }



}
