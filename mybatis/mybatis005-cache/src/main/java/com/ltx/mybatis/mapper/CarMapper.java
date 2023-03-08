package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Car;

public interface CarMapper {
    Car selectById2(Long id);

    Car selectById(Long id);
}
