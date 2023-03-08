package com.ltx.spring.dao.impl;

import com.ltx.spring.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public int insert() {
        //System.out.println("插入成功！");
        logger.info("插入成功！");
        return 0;
    }
}
