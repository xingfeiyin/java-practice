package com.yinxf.java.spi;


import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author yinxf
 * @Date 2021/5/8
 * @Description Dubbo SPI
 *
 * Dubbo SPI可以按需加载实现类，增加了IOC和AOP的特性，还有自适应扩展机制
 * Dubbo对配置文件目录的约定：
 *      META-INF/services/目录 ：该目录下的SPI配置文件是为了用来兼容Java SPI.
 *      META-INF/dubbo/目录 ：该目录存放用户自定义的SPI配置文件
 *      META-INF/dubbo/internal/目录 ：该目录存放 Dubbo 内部使用的SPI配置文件
 *
 **/
public class DubboSpi {

    public static void main(String[] args) {

        ExtensionLoader extensionLoader = ExtensionLoader.getExtensionLoader(NuanNanBobing.class);

        Object extension = extensionLoader.getExtension("");
    }
}
