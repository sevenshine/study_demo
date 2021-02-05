package com.yjm.springbootdemo.javautils.compare;

import java.util.Comparator;

/**
 * 函数式接口的实现
 */
public class MxComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareToIgnoreCase(o2.name);
    }
}
