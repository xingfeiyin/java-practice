package com.yinxf.designpattern.chain;

/**
 * @author yinxf
 * @Date 2021/5/31
 * @Description
 **/
public class ThreeInterview extends Handler {

    @Override
    public void handlerRequest(Integer times) {
        //条件判断是否属于当前handler的处理范围之内，不是则向下传递handler处理器
        if (times == 3){
            //处理业务逻辑
            System.out.println("第三次"+times +",恭喜通过了。");
        }
    }
}
