package com.ming;


import com.ming.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory = null;


    @Before
    public void testInit(){
        String file = "sqlMapConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserInfoById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            UserInfo userInfo = (UserInfo) sqlSession.selectOne("test.queryUserInfoById",5);
            System.out.println(userInfo);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testQueryUserInfoByName(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<UserInfo> userInfoList = sqlSession.selectList("test.querUserInfoByName","%rry%");
            System.out.println(userInfoList);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testAddUserInfo(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            UserInfo userInfo = new UserInfo();
            userInfo.setUsername("article");

            sqlSession.insert("test.addUserInfo",userInfo);
            sqlSession.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testModifyUserInfo(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            UserInfo userInfo = new UserInfo();
            userInfo.setUserid(3);//must be have
            userInfo.setUsername("NongFu Spring");

            sqlSession.update("test.modifyUserInfo",userInfo);
            sqlSession.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUserInfo(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("test.delUserInfo",2);
            sqlSession.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }



}