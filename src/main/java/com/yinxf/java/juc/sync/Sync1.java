package com.yinxf.java.juc.sync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yinxf
 * @Date 2021/6/22
 * @Description
 **/
public class Sync1 {
    List<Object> list = new LinkedList<>();

    public void add(Object context){
        list.add(context);
    }

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        Sync1 sync1 = new Sync1();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sync1.add(new Object());
                System.out.println("add " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while (true){
//                System.out.println("t2结束"+sync1.size());
                if (sync1.size() == 5){
                    break;
                }
            }
            System.out.println("t2结束");
        },"t2").start();

    }

}
