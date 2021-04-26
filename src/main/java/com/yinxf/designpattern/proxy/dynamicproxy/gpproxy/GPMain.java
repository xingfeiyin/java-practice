package com.yinxf.designpattern.proxy.dynamicproxy.gpproxy;

import com.yinxf.designpattern.proxy.dynamicproxy.Customer;
import com.yinxf.designpattern.proxy.staticproxy.father.Person;

/**
 * @author yinxf
 * @Date 2020/4/23
 * @Description
 **/
public class GPMain {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new GPMeiPo().getInstance(new Customer());
            System.out.println(obj.getClass());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
