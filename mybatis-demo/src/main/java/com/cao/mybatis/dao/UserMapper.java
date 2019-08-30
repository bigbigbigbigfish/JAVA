package com.cao.mybatis.dao;

import com.cao.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public User login(@Param("userName")String userName,@Param("password") String password);


    public List<User> queryUserByTableName(@Param("tableName") String tableName);
    public User queryUserById(String id);
    public List<User> queryUserAll();
    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUserById(String id);




}
