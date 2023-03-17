package com.ltx.dubbo.controller;

import com.ltx.dubbo.pojo.User;
import com.ltx.dubbo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Resource
    private UserService userService1;
    @Resource
    private UserService userService2;

    @RequestMapping("/userDetail")
    public String user(Model model,Integer id,String username){
        User user1 = userService1.queryUserById(id, username);
        User user2 = userService2.queryUserById(id, username);
        model.addAttribute("user1",user1);
        model.addAttribute("user2",user2);
        return "userDetail";
    }
}
