package com.yjm.springbootdemo.lambda_stream.methodreference;

public class TestMethodReference {
    public static void saySomething(){
        System.out.println("Hello,this is a static method");
    }

    public static void ThreadStatus()
    {
        System.out.println("Thread is running...");
    }

    public void saySomething2(){
        System.out.println("Hello, this is a non-static method");
    }

    public void ThreadStatus2()
    {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        /**
         * 函数引用方式一：通过Lambda方式指向静态函数
         * Referring static method：接口实现，通过静态函数，通过Lambda方式传递给接口实现
         */
        Sayable sayable = TestMethodReference::saySomething;
        // 调用接口方法
        sayable.say();

        /**
         * Runnable：定义好的函数式接口，Lambda作为参数传递给函数
         * 静态函数调用方式
         */
        Thread thread=new Thread(TestMethodReference::ThreadStatus);
        thread.start();


        /**
         * 函数引用方式二：指向实例化的方法（非静态方法，先实例化，然后调用方法）
         */
        TestMethodReference testMethodReference = new TestMethodReference();
        Sayable sayable1 = testMethodReference::saySomething2;
        sayable1.say();
        //匿名类的方式实现方式二
        Sayable sayable2 = new TestMethodReference()::saySomething2;
        sayable2.say();

        /**
         * 作为函数参数传入
         * Runnable interface contains only one abstract method. So, we can use it as functional interface.
         */
        Thread thread1 = new Thread(new TestMethodReference()::ThreadStatus2);
        thread1.start();

        /**
         * 函数引用方式三：指向构造器
         * You can refer a constructor by using the new keyword. Here, we are referring constructor with the help of functional interface.
         */
        Messageable messageable = Message::new;
        messageable.getMessage("Hello world");


    }
}
