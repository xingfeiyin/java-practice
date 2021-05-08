package com.yinxf.java.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yinxf
 * @Date 2021/5/7
 * @Description
 **/
public class AobingMain {
    public static void main(String[] args) {
        ServiceLoader<Aobing> serviceLoader = ServiceLoader.load(Aobing.class);

        Iterator<Aobing> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            Aobing next = iterator.next();
            next.say();
        }


    }
}
