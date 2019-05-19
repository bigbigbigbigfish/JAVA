package com.cao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanOperation {
    //工具类
    private BeanOperation() {}
    //首先取得具体的类
    // emp.name:yuisame|emp.job:Linux Coder
    public static void setBeanValue(Object actionObjt,String value) {
        //字符串的拆分
        String[] temp = value.split("\\|");
        for(int i = 0;i<temp.length ;i++) {
            String[] result = temp[i].split(":");
            //取得要真是设置的内容
            String realValue = result[1];
            //取得要设置的真实类名称
            String realClassName = result[0].split("\\.")[0];
            //取得此时要设置的属性名称
            //name
            String attrName = result[0].split("\\.")[1];

            //通过反射取得xxAction 中的真实对选哪个
            Object realObj = getRealObject(actionObjt,realClassName);
            System.out.println(realObj);
         }
    }


    private static Object getRealObject(Object actionObj, String realClassName) {
        Class<?> cls = actionObj.getClass();
        //拼装getemp方法名
        String methodName ="get" + initCap(realClassName);
        Object realObj = null;
        try {
            Method method = cls.getDeclaredMethod(methodName);
            realObj = method.invoke(actionObj);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return realObj;
    }


    public static String initCap(String str) {
        return str.substring(0,1).toUpperCase() +str.substring(1);
    }
}
