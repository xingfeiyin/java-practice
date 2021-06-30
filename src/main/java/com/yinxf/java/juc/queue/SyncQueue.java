package com.yinxf.java.juc.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yinxf
 * @Date 2021/6/25
 * @Description
 **/
public class SyncQueue<T> {

    LinkedList<T> queue = new LinkedList<>();

    private final Integer MAX = 10;
    private int count = 0;

//    Lock lock = new ReentrantLock();
//    Condition provider = lock.newCondition();
//    Condition customer = lock.newCondition();


    public synchronized void add(T t){

        while (queue.size() == MAX){
            System.out.println("provider stop");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("p " + t);

        queue.add(t);
        ++count;
        this.notifyAll();

    }

    public synchronized void remove(){
        T t = null;
        while (queue.size() == 0){
            System.out.println("customer stop");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = queue.removeFirst();
        System.out.println("c "+t);
        --count;
        this.notifyAll();

    }

    public static void main(String[] args) {

        SyncQueue<String> providerQ = new SyncQueue();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    providerQ.remove();
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    providerQ.add("add "+ j);

                }
            }).start();

        }


    }



}
