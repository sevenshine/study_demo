package com.yjm.springbootdemo.mybatis.service;

import com.yjm.springbootdemo.mybatis.domain.UserT;

public interface UserService {

    public int add(UserT user);



    /**
     * 功能描述：测试事务
     * @return
     */
    public int addAccount();

}