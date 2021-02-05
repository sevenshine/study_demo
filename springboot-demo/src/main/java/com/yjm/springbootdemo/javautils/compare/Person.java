package com.yjm.springbootdemo.javautils.compare;

/**
 * 实现Comparable，来使类Person具有排序功能
 * Comparable重写compareTo方法，在集合内部定义的方法实现排序
 */
public class Person implements Comparable<Person> {
    String name;
    int  age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("{name=%s, age=%d}", name, age);
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
    }
}
