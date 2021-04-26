package com.yinxf.designpattern.singleton.threadlocal;

/**
 * @author yinxf
 * @Date 2020/4/9
 * @Description
 **/
public class ExectorThread implements Runnable {

    public void run() {
        System.out.println(ThreadLocalSingleton.getInstance());
    }
}
