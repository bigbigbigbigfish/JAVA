package com.cao;

import com.cao.mapper.UserInfoMapper;
import com.cao.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import  java.util.*;

//开发mybatis的步骤
/***
 *  1，编写sql语句
 *  2，编写mapper接口
 *  3，编写持久化类
 *  4，编写sqlMapConfig.xml
 *  5，编写测试类
 */
public class mybaties {

    private SqlSessionFactory sqlSessionFactory = null;
    //1，怎么做？

    @Before
    public void init(){
        String file = "sqlMapConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void queryUserInfoById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserInfoMapper userInfoMapper = (UserInfoMapper) sqlSession.getMapper(UserInfoMapper.class);
            UserInfo userInfo = (UserInfo) userInfoMapper.queryUserById(3);
            System.out.println(userInfo);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void queryUserInfoByName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserInfoMapper userInfoMapper = (UserInfoMapper) sqlSession.getMapper(UserInfoMapper.class);
            List<UserInfo> userInfoList =  userInfoMapper.queryUserByName("tom");
            System.out.println(userInfoList);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUserInfo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserInfoMapper userInfoMapper = (UserInfoMapper) sqlSession.getMapper(UserInfoMapper.class);
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("bittech1");
            userInfoMapper.addUserInfo(userInfo);
            sqlSession.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void updateUserInfo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserInfoMapper userInfoMapper = (UserInfoMapper) sqlSession.getMapper(UserInfoMapper.class);
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(3);// must
            userInfo.setUserName("MMMMM");
            userInfoMapper.updateUserInfo(userInfo);
            sqlSession.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void delUserInfo(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserInfoMapper userInfoMapper = (UserInfoMapper) sqlSession.getMapper(UserInfoMapper.class);
            userInfoMapper.delUserInfo(3);
            sqlSession.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


}