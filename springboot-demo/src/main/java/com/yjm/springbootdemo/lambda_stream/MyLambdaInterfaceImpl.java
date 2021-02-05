package com.yjm.springbootdemo.lambda_stream;

public class MyLambdaInterfaceImpl implements MyLambdaInterface {
    @Override
    public void doSomethingShit(String s) {
        System.out.println(s);
    }
}
