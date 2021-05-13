package com.yinxf.designpattern.builder;

/**
 * @author yinxf
 * @Date 2021/5/13
 * @Description 建造者模式
 **/
public abstract class ItemBuilder {
    //创建产品对象
    protected Item item = new Item();

    public abstract void buildNormal();

    public abstract void buildCard();

    public abstract void buildVideo();

    //返回产品对象
    public Item getResult(){
        return item;
    }


}
