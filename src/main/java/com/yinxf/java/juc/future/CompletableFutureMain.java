package com.yinxf.java.juc.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author yinxf
 * @Date 2021/5/14
 * @Description Future模式的高阶版本—— CompletableFuture
 *  Future虽然好用，但是将任务提交给线程后，调用线程不知道这个任务何时执行完，
 *  如果调用get()或isDone()方法判断，可能进行不必要的等待，影响系统的吞吐量。
 *  JDK为了解决这个问题增加了CompletableFuture，可以理解为Future模式的升级版，
 *  最大的作用是提供了一个回调机制，可以在任务完成后，自动回调一些后续处理。
 *
 **/
public class CompletableFutureMain {

    public static void main(String[] args) throws InterruptedException {
        //创建异步执行任务
        CompletableFuture.supplyAsync(CompletableFutureMain::getPrice)
                //当getPrice执行完成后，会自动回调thenAccept()中的函数
                .thenAccept(result -> {
                    System.out.println("price:"+result);
                })
                //当出现异常时，会自动回调exceptionally()里的函数
                .exceptionally(e->{
                    e.printStackTrace();
                    return null;
                });
        Thread.sleep(200);
    }

    static Double getPrice(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟一个异常
        if (Math.random() < 0.3){
            throw new RuntimeException("Error when get price");
        }
        return Math.random()*20;
    }
}
