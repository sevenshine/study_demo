package com.yjm.springbootdemo.mybatisplus.service.impl;

import com.yjm.springbootdemo.mybatisplus.domain.UserP;
import com.yjm.springbootdemo.mybatisplus.mapper.UserMapperPlus;
import com.yjm.springbootdemo.mybatisplus.service.UserServicePlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServicePlusImpl implements UserServicePlus {

    @Autowired
    UserMapperPlus userMapper;

    @Override
    public int add(UserP user) {
        System.out.println("service---add---------");
        Integer id1 = userMapper.insert(user);
        Integer id = user.getId();
        System.out.println("id1="+id1+", id="+id);
        return id;
    }


}
