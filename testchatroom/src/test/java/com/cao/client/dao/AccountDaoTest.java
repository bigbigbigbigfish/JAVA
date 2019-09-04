package com.cao.client.dao;


import com.cao.client.entiy.User;
import org.junit.Assert;
import org.junit.Test;



public class AccountDaoTest {
    private AccountDao accountDao = new AccountDao();
    @Test
    public void userReg() {
        User user = new User();
        user.setUserName("fishee");
        user.setPassword("123");
        user.setBrief("呵呵呵呵");
        boolean flag = accountDao.userReg(user);
        Assert.assertTrue(flag);
    }

    @Test
    public void userLogin()  {
        String userName = "fishee";
        String password = "123";
        User user = accountDao.userLogin(userName,password);
        System.out.println(user);
        Assert.assertNotNull(user);
    }
}