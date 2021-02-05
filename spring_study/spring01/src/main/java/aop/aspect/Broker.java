package aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect //标注为切面
@EnableAspectJAutoProxy //开启注解AOP的支持
public class Broker {

    //切点内容
    @Before("execution(public * aop.pojo.Landlord.service(..))")
    public void before(){
        System.out.println("带租客看房");
        System.out.println("谈价格");
        System.out.println("======方法执行前=========");
    }

    @After("execution(* aop.pojo.Landlord.service(..))")
    public void after(){
        System.out.println("======方法执行后=========");
        System.out.println("交接钥匙");
    }
}
