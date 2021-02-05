package javaconfig.config;

import javaconfig.pojo.Name;
import javaconfig.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置类--》等价于applicationContext.xml
@Configuration
//@ComponentScan(basePackages = {"javaconfig"})
public class TestConfig {

    //注册一个Bean
//    @Bean("user")
    public User getUser(){
        User u = new User();
        u.setName("user111");
        return u;
    }

    /**
     * @Bean等价于xml里的配置
     * <bean id="Name" class="javaconfig.pojo.Name">
     *         <property name="name" value="hello world"/>
     *     </bean>
     */
    @Bean("user2")
    public User getUser2(){
        User u = new User();
//        u.setName("123");
        return u;
    }
    @Bean("name1")
    public Name getName(){
        Name u = new Name();
        u.setName("name111");
        return u;
    }
}
