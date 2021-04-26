package com.yinxf.designpattern.strategy.promotion;

/**
 * @author yinxf
 * @date 2020-04-25
 */
public class EmptyStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
