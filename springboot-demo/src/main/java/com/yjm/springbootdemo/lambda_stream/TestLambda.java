package com.yjm.springbootdemo.lambda_stream;

/**
 * 參考：https://www.zhihu.com/question/20125256/answer/324121308
 */
public class TestLambda {

    public static void enact(MyLambdaInterface myLambda, String s) {
        myLambda.doSomethingShit(s);
    }

    public static void main(String[] args) {
        System.out.println("test lambda_stream-----------");
        /**
         * 函数式接口，Lambda表达式本身就是一个接口的实现
         * 1、接口只有一个函数
         * 2、Lambda相当于直接是这个函数的实现
         * 3、s为传入的参数，aBlockOfCode.doSomethingShit("test111")是类方法的实现调用
         */

        MyLambdaInterface aBlockOfCode= s -> System.out.println(s);
        aBlockOfCode.doSomethingShit("test111");

        /**
         * 声明了实现类，与上面Lambda等价实现
         */
        MyLambdaInterface anInterfaceImpl = new MyLambdaInterfaceImpl();
        anInterfaceImpl.doSomethingShit("test2222");


        /**
         * Lambda作为函数参数 VS Java7需要明确的接口实现定义
         */
        enact(s -> System.out.println(s), "hello world");
        //等价于
        MyLambdaInterface myLamb = new MyLambdaInterfaceImpl();
        enact(myLamb, "hello world 222");






    }
}
