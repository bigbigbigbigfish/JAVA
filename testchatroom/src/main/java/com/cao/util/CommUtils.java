package com.cao.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommUtils {
    private  static final Gson GSON = new GsonBuilder().create();
   public static Properties loadProperties(String fileName) {
       Properties properties = new Properties();
       InputStream in = CommUtils.class.getClassLoader().getResourceAsStream(fileName);

       try {
           properties.load(in);
       } catch (IOException e) {
           return null;
       }
       return properties;
   }
    /***
     将任意队象序列化为Json字符串，Json序列化
     *
     */
    public static String objectToJson(Object o){
        return GSON.toJson(o);
    }
    /***
     Json反序列化,将Json字符串反序列化为类的反射对象
     *jsonStr json字符串
     *objClass 反序列化的类的反射对象
     */

    public static Object JsonToObject(String JsonStr,Class objClass ){

       return GSON.fromJson(JsonStr,objClass);
    }
}
