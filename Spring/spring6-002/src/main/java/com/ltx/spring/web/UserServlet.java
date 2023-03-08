package com.ltx.spring.web;

import com.ltx.spring.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {

    //@Autowired
    @Resource(name = "userService")
    private UserService userService;

    public void user(){
        userService.userInsert();
    }
}
