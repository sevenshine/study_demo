package aop;

import aop.pojo.Landlord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("aop");
        Landlord landlord=(Landlord)context.getBean("landlord");
//        Broker broker=(Broker)context.getBean("broker");
        landlord.service();
//        broker.before();

    }
}
