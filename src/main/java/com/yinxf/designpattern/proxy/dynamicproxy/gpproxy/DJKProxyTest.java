package com.yinxf.designpattern.proxy.dynamicproxy.gpproxy;

import com.yinxf.designpattern.proxy.dynamicproxy.Customer;
import com.yinxf.designpattern.proxy.dynamicproxy.JDKMeiPo;
import com.yinxf.designpattern.proxy.staticproxy.father.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author yinxf
 * @Date 2020/4/23
 * @Description
 **/
public class DJKProxyTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKMeiPo().getInstance(new Customer());
            obj.findLove();
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
            os.write(bytes);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
