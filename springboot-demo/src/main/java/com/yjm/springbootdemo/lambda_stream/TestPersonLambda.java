package com.yjm.springbootdemo.lambda_stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class TestPersonLambda {

    /**
     *  方式一：最直接的Lambda实现，Lambda表达式作为函数参数传递进去
     */
    public static void checkAndExecute(List<Person> personList,
                                       NameCheck nameCheck,
                                       Executor executor) {
        for (Person p : personList) {
            if (nameCheck.check(p)) {
                executor.execute(p);
            }
        }
    }

    /**
     * 方式二 ：利用Java8中函数式接口的包，直接替换自定义的函数式接口
     * Predicate<T>和Consumer<T>--》替换NameChecker/Executor
     *  @FunctionalInterface
     * public interface Consumer<T>{ boolean test(T t); }
     */
    public static void checkAndExecute01(List<Person> personList,
                                         Predicate<Person> personPredicate,
                                         Consumer<Person> personConsumer){
        for (Person p : personList) {
            if (personPredicate.test(p)) {
                personConsumer.accept(p);
            }
        }
    }

    /**
     * 方式二簡化：用Iterable.forEach()取代foreach loop
     * forEach()中使用Lambda
     */
    public static void checkAndExecute02(List<Person> personList,
                                         Predicate<Person> personPredicate,
                                         Consumer<Person> personConsumer){
        personList.forEach(p->{
            if (personPredicate.test(p)) {
                personConsumer.accept(p);
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("test lambda_stream & Stream-----------");
        /**
         * 需求：需要你打印出guiltyPersons List里面所有LastName以"Z"开头的人的FirstName
         */
        List<Person> guiltPesons = Arrays.asList(
                new Person("Yingxin","Xu",11),
                new Person("Yiii","Chen",20),
                new Person("Nhhhh","Zhen",25)
        );


        checkAndExecute(guiltPesons,
                p -> p.getLastName().startsWith("Z"),
                p-> System.out.println(p.getLastName()+p.getFirstName()));

        checkAndExecute01(guiltPesons,
                p -> p.getLastName().startsWith("C"),
                p-> System.out.println(p.getLastName()+p.getFirstName()));

        checkAndExecute02(guiltPesons,
                p -> p.getLastName().startsWith("C"),
                p-> System.out.println(p.getLastName()+p.getFirstName()));

        /**
         * 方式二的进一步简化：利用stream()替代静态函数
         * 直接使用stream()特性来完成
         * stream()的几个方法都是接受Predicate<T>，Consumer<T>等参数
         */
        guiltPesons.stream()
                .filter(p -> p.getLastName().startsWith("X"))
                .forEach(p-> System.out.println(p.getLastName()+p.getFirstName()));



    }
}
