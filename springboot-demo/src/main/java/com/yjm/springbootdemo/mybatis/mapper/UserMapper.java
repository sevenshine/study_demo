package com.yjm.springbootdemo.mybatis.mapper;

import com.yjm.springbootdemo.mybatis.domain.UserT;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 访问数据库的接口 dao类似于mapper
 * Mybatis3.x增删改查
 */
//@Service
@Mapper
public interface UserMapper {

    /**
     * 推荐使用#{}取值，不要用${},因为存在注入的风险
     * keyProperty java对象的属性；keyColumn表示数据库的字段
     */
    @Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime},#{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(UserT user);

    /**
     * 功能描述：根据id找对象
     * @param id
     * @return
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            //column对应数据库字段名，property对应实体类中属性名称，做一个相互映射
            @Result(column = "create_time",property = "createTime")
    })
    UserT findById(Long id);

    @Select("SELECT * FROM user")
    @Results({
            @Result(column = "create_time", property = "createTime")
    })
    List<UserT> getAll();

}
