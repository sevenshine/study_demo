package javaconfig.TestEn;

import javaconfig.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@ComponentScan("javaconfig")
@Component
public class TeUser {

    @Autowired
    private User user;

    public void test3(){
        /**
         * @Autowired 需要在容器类进行自动装配，首先TeUser需要先是一个组件
         */
        System.out.println(user.getName());
    }

}
