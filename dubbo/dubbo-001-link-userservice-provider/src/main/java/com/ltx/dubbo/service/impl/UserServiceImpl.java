package com.ltx.dubbo.service.impl;

import com.ltx.dubbo.pojo.User;
import com.ltx.dubbo.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User queryUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("张三");
        user.setAge(22);

        return user;
    }
}
