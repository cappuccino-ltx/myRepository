package com.ltx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping(value = "/req.action",method = RequestMethod.GET)
    public String req1(){

        return "main";
    }
    @RequestMapping(value = "/req.action",method = RequestMethod.POST)
    public String req2(){

        return "main";
    }
}
