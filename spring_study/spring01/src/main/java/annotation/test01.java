package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class test01 {

    @MyAnnotation
    public void test(){ }

    @MyAnnotation2(name = "kk")
    public void test1(){ }

    //只有value才能省略
    @MyAnnotation3("kk")
    public void test2(){ }
}

//元注解
//Target 表示注解用在什么地方
@Target(value= {ElementType.METHOD,ElementType.FIELD})
//Retention 表示我们的注解在什么地方有效
//runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation{

}

@Target(value= {ElementType.METHOD,ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //直接的参数：参数类型+参数名()
    String name() default "";
    int age() default 1;

    String[] schools() default{"xxx","yyy"};//数组表示
}

@Target(value= {ElementType.METHOD,ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    //一个参数用value命名，直接
    String value();
}