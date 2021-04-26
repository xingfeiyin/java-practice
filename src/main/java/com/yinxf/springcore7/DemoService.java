package com.yinxf.springcore7;

/**
 * @author yinxf
 * @date 2020-04-29
 */
@GPService
public class DemoService implements IDemoService {

    @Override
    public String get(String name) {
        return "my name is "+ name;
    }
}
