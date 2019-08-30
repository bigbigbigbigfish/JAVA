package com.cao.mybatis.dao;

import com.cao.mybatis.pojo.User;

import java.util.List;

public interface UserDao {

    public User queryUserById(String id);


    public List<User> queryUserAll();


    public void insertUser(User user);


    public void updateUser(User user);


    public void deleteUser(String id);
}
