package com.li.test.service.impl;

import com.li.test.dao.TestDao;
import com.li.test.entity.User;
import com.li.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public List<User> findUserByName(User user) {
        return testDao.findUserByName(user);
    }
}
