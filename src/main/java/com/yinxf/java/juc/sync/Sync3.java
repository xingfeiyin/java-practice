package com.yinxf.java.juc.sync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yinxf
 * @Date 2021/6/22
 * @Description
 **/
public class Sync3 {
    volatile List<Object> list = new LinkedList<>();

    public void add(Object context){
        list.add(context);
    }

    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        Sync3 sync1 = new Sync3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sync1.add(new Object());
                System.out.println("add " + i);
                //注释掉这段代码后，线程2 不能正常打印了
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
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
