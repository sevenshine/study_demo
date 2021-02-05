package com.yjm.springbootdemo.async_task.controller;

import com.yjm.springbootdemo.async_task.task.AsyncTask;
import com.yjm.springbootdemo.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("test")
public class TaskController {

    @Autowired
    AsyncTask task;


    @PostMapping("async_task")
    public JsonData exeTask() throws InterruptedException{
        long begin = System.currentTimeMillis();

        /**
         * 异步任务执行
         */
        task.task1();
        task.task2();
        task.task3();

        Thread.sleep(1000L);
        /**
         * Future<String> task4 为异步任务返回的对象
         */
        Future<String> task4 = task.task4();
        Future<String> task5 = task.task5();
        Future<String> task6 = task.task6();
        System.out.println(task4.toString());
        System.out.println(task5.toString());
        System.out.println(task6.toString());

        /**
         * 无限循环中等待任务的完成，isDone()表示任务完成
         * 异步任务完成后继续进行下一步操作
         */
        for (;;){
            if (task4.isDone() && task5.isDone() && task6.isDone()){
                break;
            }
        }

        long end = System.currentTimeMillis();
        long total = end-begin;
        System.out.println("执行总耗时="+total);

        return JsonData.buildSuccess(total);
    }


}
