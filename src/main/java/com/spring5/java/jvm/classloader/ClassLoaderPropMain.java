package com.spring5.java.jvm.classloader;

import java.net.URL;

/**
 * @author yinxf
 * @Date 2021/4/6
 * @Description
 *  从输出中验证了：系统类加载器的父类加载器是扩展类加载器。输出中扩展类加载器的父类加载器是null
 *      这是因为父类加载器不是java实现的，是C++实现的，所以获取不到。但扩展类的父类加载器是根加载器
 **/
public class ClassLoaderPropMain{
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器："+systemClassLoader);

        /**
         * 获取系统类加载器的加载路径
         */
        URL resource = systemClassLoader.getResource("");
        System.out.println("系统类的加载路径："+resource);

        //系统类加载器的父类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println("系统类加载器的父类加载器是扩展类："+parent);
        System.out.println("扩展类的加载路径："+System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的父类加载器："+parent.getParent());

    }
}
