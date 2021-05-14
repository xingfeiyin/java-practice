package com.yinxf.java.juc.future;

/**
 * @author yinxf
 * @Date 2021/5/14
 * @Description 整个future模式的核心
 **/
public class FutureData implements Data {

    protected RealData realData = null;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData){
        if (isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        //realData已经被注入，通知getResult()
        notifyAll();
    }

    /**
     * 会等待realData构造完成
     * @return
     */
    @Override
    public synchronized String getResult() {

        while (!isReady){
            try {
                //一直等待，直到realData被注入
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //真正需要的数据从realData中获取
        return realData.result;
    }
}
