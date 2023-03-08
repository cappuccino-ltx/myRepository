package com.ltx.spring.service.impl;

import com.ltx.spring.mapper.UserMapper;
import com.ltx.spring.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    /*@Autowired
    @Qualifier("userMapperForMysql")*/
    @Resource(name = "userMapper")
    private UserMapper userMapper;

    public void userInsert(){
        userMapper.insert();
    }
}
