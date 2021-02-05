package com.yjm.springbootdemo.javautils.compare;

public class Student {

    String name;
    int  age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("{name=%s, age=%d}", name, age);
    }

}
