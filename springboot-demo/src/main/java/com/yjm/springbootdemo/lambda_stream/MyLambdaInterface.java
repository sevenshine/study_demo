package com.yjm.springbootdemo.lambda_stream;

/**
 * 函数式接口中，声明@FunctionalInterface, 控制其他人在里面添加新的接口函数
 */
@FunctionalInterface
public interface MyLambdaInterface {
    public void doSomethingShit(String s);

}
