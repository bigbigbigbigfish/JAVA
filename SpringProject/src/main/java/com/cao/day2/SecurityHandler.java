package com.cao.day2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SecurityHandler implements InvocationHandler {


    private Object targetObject;
    public Object proxInstance(Object paramObject) {
        /***
         * 通过反射来生成
         */
        this.targetObject = paramObject;
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object resultObj = null;
        checkSecurity();
        try {
            resultObj = method.invoke(this.targetObject,args);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resultObj;
    }


    public void checkSecurity() {
        System.out.println("================CheckSecurity============");
    }
}
