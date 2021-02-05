package com.yjm.springbootdemo.lambda_stream;

@FunctionalInterface
public interface Executor {
    void execute(Person p);
}
