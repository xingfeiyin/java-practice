package com.spring5.java.juc;

/**
 * @author yinxf
 * @Date 2021/4/9
 * @Description
 **/
public class SynchronizedTest {




    public void method1(){
        System.out.println("method 1 start");
        try {
            synchronized (this) {
                System.out.println("method 1 execute");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 1 end");
    }

    public void method2(){
        System.out.println("method 2 start");
        try {
            synchronized (this) {
                System.out.println("method 2 execute");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 2 end");
    }


    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();
        new Thread(()-> test.method1()).start();
        new Thread(()-> test.method2()).start();

    }

}
