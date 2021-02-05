package java_base.Thread;

public class TestThread_2 {
    private int count = 1;

    //同步方法方式一，synchronized修饰，用于加锁和解锁
    public void add(int n) {
        synchronized(this) {// 锁住this
            count += n;
        }// 解锁
    }

    //同步方法方式二
    public synchronized void dec(int n) {
            count -= n;
    }

    //可重录的锁
    //获取锁的时候，不但要判断是否是第一次获取，还要记录这是第几次获取。
    // 每获取一次锁，记录+1，每退出synchronized块，记录-1，减到0的时候，才会真正释放锁。
    public synchronized void add1(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public int get(){
        return count;
    }

    public static void main(String[] args) {
        TestThread_2 test1=new TestThread_2();

//        new Thread(()->{
//            test1.add(100);
//            System.out.println(test1.get());
//        }).start();
//
//        new Thread(()->{
//            test1.dec(100);
//            System.out.println(test1.get());
//        }).start();

    }

}

