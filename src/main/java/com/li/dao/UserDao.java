package com.li.dao;

import com.li.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserDao extends BaseDao<User> {

    @Override
    User get(String id);

    @Override
    List<User> find(Map map);

    @Override
    void insert(User entity);

    @Override
    void update(User entity);

    @Override
    void deleteById(Serializable id);

    @Override
    void delete(Serializable[] ids);
}
