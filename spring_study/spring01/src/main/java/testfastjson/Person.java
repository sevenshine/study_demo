package testfastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    /**
     * 输出字段控制
     * @JSONField 注解：实现字段的自动转换
     * ordinal 指定排列顺序
     * format 格式化date属性
     * serialize 指定字段不序列化
     */
    @JSONField(name = "AGE",ordinal = 2)
    private int age;

    @JSONField(name = "FULLNAME",ordinal = 1)
    private String fullName;

    @JSONField(name = "DATE",  format="dd/MM/yyyy", ordinal = 3)
    private Date dateOfBirth;

    public Person(int age, String fullName, Date dateOfBirth) {
        super();
        this.age = age;
        this.fullName= fullName;
        this.dateOfBirth = dateOfBirth;
    }
}
