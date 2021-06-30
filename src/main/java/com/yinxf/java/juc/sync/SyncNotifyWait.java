package com.yinxf.java.juc.sync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yinxf
 * @Date 2021/6/22
 * @Description notify不释放锁
 **/
public class SyncNotifyWait {
    List<Object> list = new LinkedList<>();

    public void add(Object context){
        list.add(context);
    }

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        SyncNotifyWait sync1 = new SyncNotifyWait();

        new Thread(()->{
            System.out.println("t2启动");
            synchronized (sync1){

                try {
                    sync1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2结束");
                sync1.notify();
            }
        },"t2").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                synchronized (sync1) {
                    sync1.add(new Object());
                    System.out.println("add " + i);

                    if (sync1.size() == 5){
                        try {
                            sync1.notify();
                            sync1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        },"t1").start();


    }

}
