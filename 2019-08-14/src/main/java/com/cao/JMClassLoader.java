package com.cao;

import java.io.File;
import java.io.IOException;


/****
 * 根据Url 提前解析好 web.xml
 * 根据url 得到contorller名字
 * 根据controller得到controller完整类名称
 * 利用自定义的类加载器,加载controller类
 *          //1 根据类名称找到name 对应的 *.class
 *          //2   读取该文件的内容
 *          //3 调用defineClass 转为Class
 * 利用反射,将该类实例化
 */
public class JMClassLoader extends ClassLoader {
    private static final String Home = System.getenv("JM-HOME");

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //1 根据类名称找到name 对应的 *.class
        //2   读取该文件的内容
        //3 调用defineClass 转为Class
        File classFile =getClassFile(name);
        byte[] buf;
        try {
            buf = readClassByte(classFile);
        } catch ( IOException e) {
            throw new ClassNotFoundException(name,e);
        }

        return defineClass(name,buf,0,buf.length);


    }

    private byte[] readClassByte(File classFile) {
    }


    private File getClassFile(String name) {
        File filenemg = HOME+File.separator + "webapp" +
                File.separator + "WEB-INF" + File.separator+ "classes" + File.separator+"...";
    }
}
