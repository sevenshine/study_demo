package com.yjm.springbootdemo.lambda_stream;

@FunctionalInterface
public interface NameCheck {
    Boolean check(Person p);
}
