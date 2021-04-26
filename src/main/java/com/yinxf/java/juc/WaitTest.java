package com.yinxf.java.juc;


/**
 * @author yinxf
 * @Date 2021/4/9
 * @Description notify和notifyall
 **/
public class WaitTest {
    public synchronized void testWait(){
        System.out.println(Thread.currentThread().getName()+" start....................");
        try {
            wait(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" end...............");
    }

    public static void main(String[] args) throws InterruptedException {
        WaitTest test = new WaitTest();
        for (int i = 0;i <5;i++) {
            new Thread(()->test.testWait()).start();
        }
        synchronized (test){
            test.notify();
        }
        Thread.sleep(3000);
        System.out.println("--------------------------------");

        synchronized (test){
            test.notifyAll();
        }
    }
}
