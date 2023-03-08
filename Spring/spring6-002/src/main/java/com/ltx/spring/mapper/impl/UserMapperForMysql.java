package com.ltx.spring.mapper.impl;


import com.ltx.spring.mapper.UserMapper;
import org.springframework.stereotype.Repository;

//@Repository("userMapper")
public class UserMapperForMysql implements UserMapper {

    @Override
    public int insert() {
        System.out.println("mysql数据库插入成功！");
        return 0;
    }
}
