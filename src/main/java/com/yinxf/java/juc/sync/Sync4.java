package com.yinxf.java.juc.sync;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yinxf
 * @Date 2021/6/22
 * @Description
 **/
public class Sync4 {
    List<Object> list = new LinkedList<>();

    public void add(Object context){
        list.add(context);
    }

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        Sync4 sync1 = new Sync4();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronized (sync1) {
                    sync1.add(new Object());
                    System.out.println("add " + i);
                }
            }
        },"t1").start();

        new Thread(()->{
            synchronized (sync1) {
                while (true){
                    if (sync1.size() == 5){
                        break;
                    }
                }
            }
            System.out.println("t2结束");
        },"t2").start();

    }

}
