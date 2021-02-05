package com.yjm.springbootdemo.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yjm.springbootdemo.domain.JsonData;
import com.yjm.springbootdemo.mybatisplus.domain.UserP;
import com.yjm.springbootdemo.mybatisplus.mapper.UserMapperPlus;
import com.yjm.springbootdemo.mybatisplus.service.UserServicePlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * controller api接口
 */
@RestController
@RequestMapping("/test/user")
public class UserControllerPlus {

    @Autowired
    UserServicePlus userService;

    @Autowired
    UserMapperPlus userMapper;

    @PostMapping("addplus")
    public Object add(){
        System.out.println("controller---add---------");
        UserP user=new UserP();
        user.setAge(15);
        user.setCreateTime(new Date());
        user.setName("yjm2");
        user.setPhone("112233");

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
    @PostMapping("findallplus")
    public Object findAll(){
        System.out.println("findall------------");
        return JsonData.buildSuccess(userMapper.selectById(21));
    }

    @PostMapping("testQueryWrapper")
    public Object testQueryWrapper(){
        // Step1：创建一个 QueryWrapper 对象
        QueryWrapper<UserP> queryWrapper= new QueryWrapper<>();

        /**
         * 条件构造器Wrapper：用于定义各种各样的条件（where）
         * 这里的select字段按照数据库字段名来
         * lt: < 20
         */
        // Step2： 构造查询条件
        queryWrapper.select("id", "name","create_time").lt("id", 20);

        // Step3：执行查询
        List<UserP> list= userMapper.selectList(queryWrapper);

        /**
         * list打印到控制台
         */
        list.forEach(System.out::println);

        return JsonData.buildSuccess(list);
    }

    @PostMapping("testUpdateWrapper")
    public Object testUpdateWrapper(){
        // 更新用户数据的wrapper
        UpdateWrapper<UserP> userPUpdateWrapper=new UpdateWrapper<>();

        /**
         * 【遗留问题】这里多了一个age的赋值，不知道是哪里来的，导致age先赋值为0了
         * ==>  Preparing: UPDATE study_test.user SET age=?, name=?,age=age -2 WHERE (id = ?)
         * ==> Parameters: 0(Integer), yanjiaming(String), 19(Integer)
         */
        //修改数据的语句
        userPUpdateWrapper.set("name", "yanjiaming");
        userPUpdateWrapper.setSql("age=age -"+"2");
        //条件
        userPUpdateWrapper.eq("id", 19);

        UserP userP = new UserP();

        userMapper.update(userP, userPUpdateWrapper);

        System.out.println(userP);

        return userP;

    }


}
