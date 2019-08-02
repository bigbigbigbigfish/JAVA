package com.cao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserManager iUserManager = (IUserManager) context.getBean("userManagerImpl");
        iUserManager.addUser("abc","111");


    }
}
