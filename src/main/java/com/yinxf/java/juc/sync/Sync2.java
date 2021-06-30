package com.yinxf.java.juc.sync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yinxf
 * @Date 2021/6/22
 * @Description
 * volatile作用在对象上，应该是引用地址具有可见性，但是对象里的内容变化，volatile是没法保证的
 * 此处加上volatile，线程2可以正常打印，说明在停顿的这1秒中，线程正常更新list的size
 **/
public class Sync2 {
    volatile List<Object> list = new LinkedList<>();

    public void add(Object context){
        list.add(context);
    }

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        Sync2 sync1 = new Sync2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sync1.add(new Object());
                System.out.println("add " + i);
                //每次停1秒，线程2可以正常打印
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                if (sync1.size() == 5){
                    break;
                }
            }
            System.out.println("t2结束");
        },"t2").start();

    }

}
