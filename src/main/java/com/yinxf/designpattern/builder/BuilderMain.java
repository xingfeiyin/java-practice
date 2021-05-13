package com.yinxf.designpattern.builder;

import com.alibaba.fastjson.JSON;

/**
 * @author yinxf
 * @Date 2021/5/13
 * @Description
 **/
public class BuilderMain {
    public static void main(String[] args) {
        //使用导演类
        ItemBuilder builder = new ItemConcreteBuilder();
        ItemDirector director = new ItemDirector(builder);
        Item item = director.normalConstruct();
        System.out.println(JSON.toJSONString(item));

        item = director.cardConstruct();
        System.out.println(JSON.toJSONString(item));


        //剔除导演类
        ItemBuilder builder1 = new ItemConcreteBuilder();
        builder1.buildNormal();
        Item result = builder1.getResult();
        System.out.println(JSON.toJSONString(result));


    }
}
