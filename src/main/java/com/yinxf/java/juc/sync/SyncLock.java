package com.yinxf.java.juc.sync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yinxf
 * @Date 2021/6/22
 * @Description 两个CountDownLatch 实现
 **/
public class SyncLock {
    List<Object> list = new LinkedList<>();

    public void add(Object context){
        list.add(context);
    }

    public int size(){
        return list.size();
    }

    static  Thread t1 ,t2 ;
    public static void main(String[] args) {
        SyncLock sync1 = new SyncLock();

        t2 = new Thread(()->{
            System.out.println("t2启动");
            LockSupport.park();
            LockSupport.unpark(t1);
            System.out.println("t2结束");
        },"t2");

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        t1 = new Thread(()->{
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                sync1.add(new Object());
                System.out.println("add " + i);

                if (sync1.size() == 5){
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }

            }
        },"t1");

        t2.start();
        t1.start();

    }

}
