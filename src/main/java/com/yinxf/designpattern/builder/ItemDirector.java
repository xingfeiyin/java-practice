package com.yinxf.designpattern.builder;

/**
 * @author yinxf
 * @Date 2021/5/13
 * @Description 导演类，指导我们怎么去创建对象
 **/
public class ItemDirector {
    private ItemBuilder itemBuilder;

    public ItemDirector(ItemBuilder itemBuilder) {
        this.itemBuilder = itemBuilder;
    }

    public Item normalConstruct(){
        itemBuilder.buildNormal();
        return itemBuilder.getResult();
    }

    public Item cardConstruct(){
        itemBuilder.buildCard();
        return itemBuilder.getResult();
    }

    public Item videoConstruct(){
        itemBuilder.buildVideo();
        return itemBuilder.getResult();
    }
}
