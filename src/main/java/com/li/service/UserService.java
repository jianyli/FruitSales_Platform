package com.li.service;

import com.li.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserService {
    User get(String id);

    List<User> find(Map map);

    void insert(User entity);

    void update(User entity);

    void deleteById(Serializable id);

    void delete(Serializable[] ids);
}
