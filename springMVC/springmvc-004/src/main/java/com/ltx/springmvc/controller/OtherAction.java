package com.ltx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherAction {
    @RequestMapping("/other.action")
    public String other(){

        return "main";
    }
}
