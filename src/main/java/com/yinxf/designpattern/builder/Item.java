package com.yinxf.designpattern.builder;

import lombok.Data;

/**
 * @author yinxf
 * @Date 2021/5/13
 * @Description
 **/
@Data
public class Item {
    //必填
    private String itemName ;
    //必填
    private Integer type ;
    //卡券必填
    private String code ;
    //视频必填
    private String url ;
}
