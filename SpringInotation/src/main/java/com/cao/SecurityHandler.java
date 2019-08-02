package com.cao;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityHandler {

    @Pointcut("execution(* com.cao.UserManagerImpl.*(..))")
    private void allMethod(){}

    @Before("allMethod()")
    public void checkSecurity(){
        System.out.println("=======checkSecurity()==========");
    }
}
