package java_base.Thread;//package com.yjm.test.java_base.Thread;
//
//public class TestThread_1 {
//    public static void main(String[] args) {
//        //启动新线程
//        //在main()方法中启动线程:实例化一个Thread实例，然后调用它的start()方法
//        Thread t = new Thread();
//        t.start();
//
//        System.out.println("[t1 testing.............]");
//        //方式一：线程执行指定代码，覆写run()方法
//        //start()方法会在内部自动调用实例的run()方法
//        Thread t1 = new MyThread();
//        t1.start();
//
//        try { Thread.sleep(30); } catch (InterruptedException e) {}
//        System.out.println("[t2 testing.............]");
//        //方式二：调用线程，创建Thread实例时，传入一个Runnable实例
//        Thread t2 = new Thread(new MyRunnable());
//        t2.start(); // 启动新线程
//
//
//        try { Thread.sleep(30); } catch (InterruptedException e) {}
//        System.out.println("[t3 testing.............]");
//        //方式三：lambda语法进一步简写，直接代码写到创建语句中
//        Thread t3 = new Thread(()->{
//            System.out.println("t3: start new thread!");
//        });
//        t3.start();
//
//        try { Thread.sleep(30); } catch (InterruptedException e) {}
//        System.out.println("[t4 testing.............]");
//
//        Thread t4 = new Thread(() -> {
//            System.out.println("hello");
//        });
//        System.out.println("start");
//        t4.start();
//        try{
//            //线程插入join()，等线程处理完后才进行main()主线程的处理
//            t4.join();
//        }catch(InterruptedException e){ }
//        System.out.println("end");
//
//        try { Thread.sleep(30); } catch (InterruptedException e) {}
//        System.out.println("[t5 testing.............]");
//
//    }
//}
//
////从Thread派生一个自定义类，然后覆写run()方法
//class MyThread extends Thread {
//    @Override
//    public void run() {
//        System.out.println("start new thread!");
//    }
//}
//
//class MyRunnable implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("start new thread!");
//    }
//}