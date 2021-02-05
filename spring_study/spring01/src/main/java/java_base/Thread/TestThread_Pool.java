package java_base.Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread_Pool {


    public static void main(String[] args) {
        // 创建固定大小的线程池:
        ExecutorService executorService= Executors.newFixedThreadPool(4);

        for (int i=0; i<6; i++ ) {
            // 提交任务
            executorService.submit(new Task(""+i));
        }

        //hutdown()方法关闭线程池的时候，它会等待正在执行的任务先完成，然后再关闭
        executorService.shutdown();

    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }
}