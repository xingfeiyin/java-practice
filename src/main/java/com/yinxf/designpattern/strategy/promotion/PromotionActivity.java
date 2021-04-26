package com.yinxf.designpattern.strategy.promotion;

/**
 * @author yinxf
 * @date 2020-04-25
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }
    public void execute(){
        promotionStrategy.doPromotion();
    }
}
