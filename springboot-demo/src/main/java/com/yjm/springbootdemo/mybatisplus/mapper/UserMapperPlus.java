package com.yjm.springbootdemo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yjm.springbootdemo.mybatisplus.domain.UserP;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 访问数据库的接口 dao类似于mapper
 * Mybatis3.x增删改查
 *
 * @Mapper和 @mapperscan 二选一即可，扫描到对应Bean
 */
//@Mapper
public interface UserMapperPlus extends BaseMapper<UserP> {

}
