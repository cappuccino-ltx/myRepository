package com.ltx.springmvc.controller;


import com.ltx.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class DataAction {

    @RequestMapping("/data.action")
    public String data(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session,
                       Map map,
                       Model model,
                       ModelMap modelMap){

        User user = new User("张三",20);

        request.setAttribute("requestUser",user);
        session.setAttribute("sessionUser",user);
        map.put("mapUser",user);
        model.addAttribute("modelUser",user);
        modelMap.addAttribute("modelMapUser",user);

        return "main";
    }
}
