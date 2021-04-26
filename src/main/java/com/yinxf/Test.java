package com.yinxf;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yinxf
 * @Date 2020/12/28
 * @Description
 **/
public class Test {

    public static void main(String[] args) {
        String fileName = "100000000000004_D20201110142529831_20201110142529.txt";
        String[] s = fileName.split("_");
        s[1] = s[1].replaceFirst("D","E");
        String fsiBatchNo = StringUtils.join(s,"_");
        String batchNo = s[1].substring(1);
        System.out.println(fsiBatchNo);
        System.out.println(batchNo);

        System.out.println(fileName.substring(fileName.lastIndexOf(".") + 1));
    }
}
