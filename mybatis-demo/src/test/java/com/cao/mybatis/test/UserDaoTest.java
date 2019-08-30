package com.cao.mybatis.test;

import com.cao.mybatis.dao.UserDao;
import com.cao.mybatis.dao.impl.UserDaoimpl;
import com.cao.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        //mybatis-config.xml
        String resource = "mybatis-config.xml";
        //读取配置文件
        InputStream is = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        this.userDao = sqlSession.getMapper(UserDao.class);
    }

    @org.junit.Test
    public void queryUserById() {

        System.out.println(this.userDao.queryUserById("1"));
    }

    @org.junit.Test
    public void queryUserAll() {
        List<User> userList = this.userDao.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void insertUser() {
        User user = new User();
        user.setId("99");
        user.setAge(16);
        user.setBirthday(new Date("1990/09/02"));
        user.setName("呵呵");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("evan");
        this.userDao.insertUser(user);
        this.sqlSession.commit();

    }

    @org.junit.Test
    public void updateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("呵呵");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("tomcat");
        user.setId("10");
        this.userDao.updateUser(user);
        this.sqlSession.commit();

    }

    @org.junit.Test
    public void deleteUser() {
        this.userDao.deleteUser("4");
        this.sqlSession.commit();
    }
}