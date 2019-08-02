package com.ming;


import com.ming.mapper.IUserInfo;
import com.ming.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;


public class MyBatisTest3 {

    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;

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
        try {
            sqlSession = sqlSessionFactory.openSession();
            IUserInfo userInfoMapper = sqlSession.getMapper(IUserInfo.class);
            UserInfo userInfo = userInfoMapper.queryUserInfoById(4);
            System.out.println(userInfo);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


}
