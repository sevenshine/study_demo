package com.yjm.springbootdemo.mybatis.service.impl;

import com.yjm.springbootdemo.mybatis.domain.UserT;
import com.yjm.springbootdemo.mybatis.mapper.UserMapper;
import com.yjm.springbootdemo.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int add(UserT user) {
        System.out.println("service---add---------");
        userMapper.insert(user);
        int id = user.getId();

        return id;
    }

    @Override
    /**
     * 传播行为
     * PROPAGATION_REQUIRED--支持当前事务，如果当前没有事务，就新建一个事务,最常见的选择
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public int addAccount() {

        UserT user = new UserT();
        user.setAge(9);
        user.setCreateTime(new Date());
        user.setName("事务测试");
        user.setPhone("000121212");

        userMapper.insert(user);

        //抛异常--》导致事务不生效
        int i = 19/0;

        return user.getId();
    }
}
