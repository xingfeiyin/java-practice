package com.yinxf.java.juc.future;

/**
 * @author yinxf
 * @Date 2021/5/14
 * @Description
 **/
public class Client {

    /**
     * 这是一个异步方法，返回的Data接口是一个future
     * @param queryStr
     * @return
     */
    public Data request(final String queryStr){
        final FutureData futureData = new FutureData();
        new Thread(()->{
            //realData的构建很慢，所以在单独的线程中进行
            RealData realData = new RealData(queryStr);
            //setRealData()的时候会notify()等待这个future上的对象
            futureData.setRealData(realData);
        }).start();

        //futureData会被立即返回，不会等待RealData被构造完成
        return futureData;
    }

}
