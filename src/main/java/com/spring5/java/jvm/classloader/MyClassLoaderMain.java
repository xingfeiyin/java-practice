package com.spring5.java.jvm.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author yinxf
 * @Date 2021/4/6
 * @Description
 *      ClassLoader中的defineClass方法是将class二进制数组转换为Class对象
 **/
public class MyClassLoaderMain extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        //
        String fileSub = name.replace("\\.", "/");
        String classFileName = fileSub + ".class";
        File classFile = new File(classFileName);

        //判断文件是否存在，系统负责将文件转换为class对象
        if (classFile.exists()){
            try {
                //将class文件的二进制数据读入数组
                byte[] raw = getBytes(classFileName);
                //调用classloader的defineClass方法将二进制数据转换为class对象
                clazz = defineClass(name,raw,0,raw.length);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //如果clazz为null，表示加载失败，抛出异常
        if (clazz == null){
            throw new ClassNotFoundException(name);
        }

        return clazz;
    }

    private byte[] getBytes(String classFileName) throws IOException {
        File file = new File(classFileName);
        long length = file.length();
        byte[] raw = new byte[(int) length];
        try(FileInputStream fis = new FileInputStream(file)){
            int read = fis.read(raw);
            if (read != length){
                throw new IOException("无法读取全部文件");
            }
            return raw;
        }
    }

    public static void main(String[] args) throws Exception {
        String classPath = "com.spring5.java.jvm.classloader.Hello";
        MyClassLoaderMain classLoaderMain = new MyClassLoaderMain();
        Class<?> aClass = classLoaderMain.loadClass(classPath);
        Method main = aClass.getMethod("test", String.class);
        System.out.println(main);
        main.invoke(aClass.newInstance(),"hello world");
    }
}
