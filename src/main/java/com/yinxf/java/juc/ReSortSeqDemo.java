package com.yinxf.java.juc;

/**
 * @author yinxf
 * @Date 2021/3/28
 * @Description 禁止指令重排序demo ，
 *  语句1 和语句2 可能进行重排序，排序后，语句3的输出结果会不同。
 *
 **/
public class ReSortSeqDemo {

    private int num = 0;
    private boolean flag = false;

    public void method1(){
        num = 1;        //语句1
        flag = true;    //语句2
    }

    public void method2(){

        if (flag){
            num = num + 5; //语句3
            System.out.println(num);
        }
    }


}
