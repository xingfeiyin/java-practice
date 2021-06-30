package com.yinxf.java.juc.sync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yinxf
 * @Date 2021/6/22
 * @Description 两个CountDownLatch 实现
 **/
public class SyncCountDownLatch {
    List<Object> list = new LinkedList<>();

    public void add(Object context){
        list.add(context);
    }

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        SyncCountDownLatch sync1 = new SyncCountDownLatch();

        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch1 = new CountDownLatch(1);

        new Thread(()->{
            System.out.println("t2启动");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2结束");
            latch1.countDown();
        },"t2").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                sync1.add(new Object());
                System.out.println("add " + i);

                if (sync1.size() == 5){
                    latch.countDown();
                    try {
                        latch1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        },"t1").start();


    }

}
