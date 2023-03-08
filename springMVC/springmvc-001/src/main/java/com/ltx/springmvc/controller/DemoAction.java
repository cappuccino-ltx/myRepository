package com.ltx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoAction {


    @RequestMapping("/demo.action")
    public String demo(){
        return "main";
    }
}
