package com.yinxf.java.jvm.notinitialization;

/**
 * @author yinxf
 * @Date 2021/3/10
 * @Description
 **/
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}
