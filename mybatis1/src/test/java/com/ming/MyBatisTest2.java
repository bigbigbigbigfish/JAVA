package com.ming;


import com.ming.mapper.IUserInfo;
import com.ming.mapper.UserInfoImpl;
import com.ming.po.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class MyBatisTest2 {

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
        try {
            IUserInfo iUserInfoDAO = new UserInfoImpl(sqlSessionFactory);
            UserInfo userInfo = iUserInfoDAO.queryUserInfoById(3);
            System.out.println(userInfo);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
//    public void testQueryUserInfoByName(){
//        try {
//        }
//    }

}
