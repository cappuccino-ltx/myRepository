package com.ltx.dubbo.controller;

import com.ltx.dubbo.pojo.User;
import com.ltx.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String user(Model model,Integer id, String name){
        User user = userService.queryUserById(id, name);
        model.addAttribute("user",user);
        return "userDetail";
    }
}
