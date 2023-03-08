package com.ltx.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);
    public User() {
        logger.info("User类的无参数构造方法执行了！");
    }
}
