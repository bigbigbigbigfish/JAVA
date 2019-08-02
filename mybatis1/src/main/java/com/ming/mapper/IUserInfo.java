package com.ming.mapper;

import com.ming.po.UserInfo;

import java.util.List;

public interface IUserInfo {

    public UserInfo queryUserInfoById(int myid) throws Exception;
    public void QueryUserInfoByName(String name) throws  Exception;

}