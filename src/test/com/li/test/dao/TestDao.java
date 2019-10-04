package com.li.test.dao;

import com.li.test.entity.User;

import java.util.List;

public interface TestDao {
    public List<User> findUserByName(User user);
}
