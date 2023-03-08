package com.ltx.spring.service.impl;

import com.ltx.spring.dao.UserDao;
import com.ltx.spring.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int userInsert() {
        userDao.insert();
        return 0;
    }
}
