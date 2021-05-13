package com.yinxf.designpattern.builder;

/**
 * @author yinxf
 * @Date 2021/5/13
 * @Description 创建具体建造者类
 **/
public class ItemConcreteBuilder extends ItemBuilder {
    @Override
    public void buildNormal() {
        item.setItemName("普通商品");
        item.setType(1);
    }

    @Override
    public void buildCard() {
        item.setItemName("卡券商品");
        item.setCode("12345");
        item.setType(2);
    }

    @Override
    public void buildVideo() {
        item.setItemName("视频商品");
        item.setType(3);
        item.setUrl("http://www.baidu.com");
    }
}
