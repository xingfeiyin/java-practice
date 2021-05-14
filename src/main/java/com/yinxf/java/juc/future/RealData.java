package com.yinxf.java.juc.future;

/**
 * @author yinxf
 * @Date 2021/5/14
 * @Description
 **/
public class RealData implements Data {

    protected final String result ;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer(para);
        //假设这里很慢，构造realData不是一个容易的事
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
