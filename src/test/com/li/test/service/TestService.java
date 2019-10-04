package com.li.test.service;

import com.li.test.entity.User;

import java.util.List;

public interface TestService {
    public List<User> findUserByName(User user);
}
