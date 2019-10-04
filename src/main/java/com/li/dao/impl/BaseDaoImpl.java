package com.li.dao.impl;

import com.li.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sessionFactory) {
        super.setSqlSessionFactory(sessionFactory);
    }
    private String ns;  //命名空间

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    @Override
    public T get(String id) {
        return this.getSqlSession().selectOne(ns + ".get", id);
    }

    @Override
    public List<T> find(Map map) {
        List<T> list = this.getSqlSession().selectList(ns +".find", map);
        return list;
    }

    @Override
    public void insert(T entity) {
        this.getSqlSession().insert(ns +".insert", entity);
    }

    @Override
    public void update(T entity) {
        this.getSqlSession().update(ns +".update", entity);
    }

    @Override
    public void deleteById(Serializable id) {
        this.getSqlSession().delete(ns + ".deleteById", id);
    }

    @Override
    public void delete(Serializable[] ids) {
        this.getSqlSession().delete(ns + ".delete", ids);
    }
}
