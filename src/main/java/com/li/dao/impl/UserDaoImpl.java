package com.li.dao.impl;

import com.li.dao.UserDao;
import com.li.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super.setNs("mapper.UserMapper");
    }
}
