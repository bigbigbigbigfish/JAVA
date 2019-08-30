package com.cao.mybatis.dao.impl;

import com.cao.mybatis.dao.UserDao;
import com.cao.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoimpl implements UserDao {

    public UserDaoimpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public SqlSession sqlSession;

    public User queryUserById(String id) {
        return this.sqlSession.selectOne("UserDao.queryUserById",id);
    }

    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser",user);
    }

    public void updateUser(User user) {
        this.sqlSession.update("UserDao.updateUser",user);
    }

    public void deleteUser(String id) {
        this.sqlSession.delete("UserDao.deleteUser",id);
    }
}
