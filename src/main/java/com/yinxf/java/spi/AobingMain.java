package com.yinxf.java.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yinxf
 * @Date 2021/5/7
 * @Description Java SPI机制
 * Java SPI在查找扩展实现类的时候遍历SPI配置文件并将实现类全部实例化。
 * 假如实现类初始化的过程比较耗时，但代码里又用不上它，这就产生了资源的浪费。
 *
 *
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
