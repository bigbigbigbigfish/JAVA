package com.ming.mapper;

import com.ming.po.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserInfoImpl implements IUserInfo {


    private SqlSessionFactory sqlSessionFactory = null;

    public UserInfoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public UserInfo queryUserInfoById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserInfo userInfo = sqlSession.selectOne("test.queryUserInfoById",id);
        return userInfo;
    }

    public void QueryUserInfoByName(String name) throws Exception {

    }


}
