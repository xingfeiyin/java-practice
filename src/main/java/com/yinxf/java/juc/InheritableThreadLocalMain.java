package com.yinxf.java.juc;

import java.util.stream.IntStream;

/**
 * @author yinxf
 * @Date 2021/5/13
 * @Description InheritableThreadLocal可以访问主线程中的ThreadLocal对象
 *      可以再父子线程之间传递参数
 **/
public class InheritableThreadLocalMain {


    public static void main(String[] args) {

//        ThreadLocal local = new ThreadLocal();
        ThreadLocal local = new InheritableThreadLocal();


        IntStream.range(0,10).forEach(i->{
            local.set(i);

            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+":"+local.get());
            }).start();

        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
