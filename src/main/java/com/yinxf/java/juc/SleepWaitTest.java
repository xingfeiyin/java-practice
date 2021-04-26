package com.yinxf.java.juc;

/**
 * @author yinxf
 * @Date 2021/4/9
 * @Description sleep 和 wait
 *  sleep暂停期间一直持有monitor对象锁，其他线程是不能进入的
 *     而wait方法则不同，当调用wait方法后，当前线程会释放持有的monitor对象锁，
 *     因此，其他线程还可以进入到同步方法，线程被唤醒后，需要竞争锁，获取到锁之后再继续执行
 **/
public class SleepWaitTest {

    public synchronized void sleepTest(){
        System.out.println(Thread.currentThread().getName()+" sleep start.....................");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" sleep end .....................");

    }

    public synchronized void waitTest(){
        System.out.println(Thread.currentThread().getName()+" wait start.......................");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" wait end ...................");
    }

    public static void main(String[] args) {
        SleepWaitTest test = new SleepWaitTest();
        for (int i = 0; i < 3; i++) {
            new Thread(()->test.sleepTest()).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------");

        SleepWaitTest test1 = new SleepWaitTest();
        for (int i = 0; i < 3; i++) {
            new Thread(()->test1.waitTest()).start();
        }



    }
}
