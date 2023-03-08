package com.ltx.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request,String username,String password){
        if("admin".equals(username) && "123".equals(password)){
            request.getSession().setAttribute("username",username);
            return "main";
        }else {
            request.setAttribute("news", "账号或密码错误！");
            return "login";
        }
    }
    @RequestMapping("main")
    public String main(){
        return "main";
    }
}
