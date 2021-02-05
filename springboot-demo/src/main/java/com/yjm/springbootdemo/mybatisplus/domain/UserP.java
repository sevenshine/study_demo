package com.yjm.springbootdemo.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
/**
 * @TableName 用来指定数据库表名
 * value:数据库表名称
 * schema：数据库名
 */
@TableName(value = "user", schema = "study_test")
public class UserP {

    /**
     * @TableId 指定字段的属性,主键
     * 数据中的表设计的是自增,type需要对应进行配置
     * --》这点和mybatis不同，plus中需要直接指明自增字段，不然insert后的user对象中不会反回这个自增的id
     */
    @TableId(value="id",type= IdType.AUTO)
    private int id;

    private String name;

    private String phone;

    private int age;

    @TableField(value="create_time")
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
