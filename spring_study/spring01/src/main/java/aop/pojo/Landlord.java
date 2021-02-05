package aop.pojo;

import org.springframework.stereotype.Component;

@Component
public class Landlord {

    public void service(){
        System.out.println("签合同");
        System.out.println("收房租");
    }

}
