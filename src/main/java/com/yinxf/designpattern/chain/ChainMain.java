package com.yinxf.designpattern.chain;

/**
 * @author yinxf
 * @Date 2021/5/31
 * @Description
 **/
public class ChainMain {

    public static void main(String[] args) {
        Handler first = new FirstInterview();
        Handler second = new SecondInterview();
        Handler three = new ThreeInterview();
        first.setHandler(second);
        second.setHandler(three);

        //第一次
        first.handlerRequest(1);
        System.out.println();

        //第二次
        first.handlerRequest(2);
        System.out.println();

        //第三次
        first.handlerRequest(3);
        System.out.println();

    }
}
