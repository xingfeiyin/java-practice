package com.yinxf.designpattern.chain;

/**
 * @author yinxf
 * @Date 2021/5/31
 * @Description
 **/
public abstract class Handler {
    protected Handler handler ;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void handlerRequest(Integer times);
}
