package com.yjm.springbootdemo.javautils.compare;

import java.util.*;

/**
 * 两种方式实现类的比较
 * Collection.sort()调用进行排序
 * Lambda方式进行简化处理
 * 第二种方式，通过Lambda方式传入比较方法 √
 */
public class TestCompare {

    public static void main(String[] args) {
        System.out.println("test Comparable---------");
        /**
         * 比较方式一：直接类Person实现Comparable
         * sort对实现了Comparable的类Person进行排序
         * public static <T extends Comparable<? super T>> void sort(List<T> list) {
         *         list.sort(null);
         *     }
         */
        ArrayList<Person> personArrayList=new ArrayList<Person>();
        personArrayList.add(new Person("ccc",31));
        personArrayList.add(new Person("ddd",41));
        personArrayList.add(new Person("aaa",11));
        personArrayList.add(new Person("bbb",21));

        //这里会自动调用Person中重写的compareTo方法
        Collections.sort(personArrayList);
        //重写了toString方法
        System.out.println(personArrayList.toString());


        System.out.println("test Comparator-----------");
        List<Student> studentList=Arrays.asList(
                new Student("bbb",31),
                new Student("aaa",31),
                new Student("ccc",31)
        );
        List<Student> studentList1=new ArrayList<>();
        List<Student> studentList2=new ArrayList<>();
        //对象的拷贝
        studentList1.addAll(studentList);
        studentList2.addAll(studentList);

        /**
         * 比较方式二：直接方法中传入比较器Comparator
         * 參數中传入一个实现了Comparator的类--》Lambda表达式来实现函数式接口的方式来简化
         *  public static <T> void sort(List<T> list, Comparator<? super T> c) {
         *         list.sort(c);
         *     }
         */
        Collections.sort(studentList, new MxComparator());
        //简化一：匿名类
        Collections.sort(studentList1, new Comparator<Student>() {
            @Override
            //函数式接口的实现
            public int compare(Student o1, Student o2) {
                return o1.name.compareToIgnoreCase(o2.name);
            }
        });
        //简化二：Lambda表达式
        Collections.sort(studentList2, (Student o1, Student o2)->{
            return o1.name.compareToIgnoreCase(o2.name);
        });


    }
}
