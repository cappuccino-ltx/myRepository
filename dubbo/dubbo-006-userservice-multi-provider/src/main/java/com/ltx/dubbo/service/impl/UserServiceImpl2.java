package com.ltx.dubbo.service.impl;

import com.ltx.dubbo.pojo.User;
import com.ltx.dubbo.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService2")
public class UserServiceImpl2 implements UserService {
    @Override
    public User queryUserById(Integer id, String username) {
        User user = new User();
        user.setId(id);
        user.setName(username + "-2");
        return user;
    }
}
