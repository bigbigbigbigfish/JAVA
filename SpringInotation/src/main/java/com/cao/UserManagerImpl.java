package com.cao;

/**
 * Author:lxy1999
 * Created:2019/7/26
 *
 * UserManagerImpl == TargetObject
 */
public class UserManagerImpl implements IUserManager{


    public void addUser(String username, String password) {
        System.out.println("=========UserManagerImpl.addUser()===========");
    }

    public void modifyUser(int id, String username, String password) {
        System.out.println("=========UserManagerImpl.modifyUser()===========");
    }
}