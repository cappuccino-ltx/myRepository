package com.ltx.spring.mapper.impl;

import com.ltx.spring.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;

@Repository("userMapper")
public class UserMapperForOracle implements UserMapper {
    @Override
    public int insert() {

        System.out.println("Oracle数据库哦插入成功！");
        return 0;
    }
}
