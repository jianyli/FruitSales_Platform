package com.li.test.dao.impl;

import com.li.test.dao.TestDao;
import com.li.test.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TestDaoImpl implements TestDao {
    @Autowired
    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession = null;
    private SqlSession getSqlSession() {
        if (sqlSession == null) {
            sqlSession = sessionFactory.openSession();
        }
        return sqlSession;
    }
    @Override
    public List<User> findUserByName(User user) {
        List<User> uList = getSqlSession().selectList("test.findUserByName","%"+user.getName()+"%");
        return uList;
    }
}
