package com.yinxf.designpattern.strategy.pay;

/**
 * @author yinxf
 * @date 2020-04-25
 */
public class Order {
    private String uid ;
    private String orderId;
    private double amount ;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }
    //完美地解决了switch的过程，不需要在代码中写switch了
    //更不需要if....else if
    public PayState pay(){
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public PayState pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用"+payment.getName());
        System.out.println("本次交易金额为："+amount +",开始扣款。。。。");

        return payment.pay(uid,amount);
    }
}
