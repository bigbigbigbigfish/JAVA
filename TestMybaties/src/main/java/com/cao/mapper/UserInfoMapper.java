package com.cao.mapper;

import com.cao.po.UserInfo;

import java.util.List;

public interface UserInfoMapper {

    public UserInfo queryUserById(int id) throws Exception;
    public List<UserInfo> queryUserByName(String name) throws Exception;
    public void addUserInfo(UserInfo userInfo) throws Exception;
    public void updateUserInfo(UserInfo userInfo) throws Exception;
    public void delUserInfo(int id) throws Exception;
}
