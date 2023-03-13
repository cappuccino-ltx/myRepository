package com.ltx.dubbo.service;

import com.ltx.dubbo.pojo.User;

public interface UserService {
    User queryUserById(Integer id,String username);
}
