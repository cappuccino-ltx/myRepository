package com.ltx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpAction {

    @RequestMapping("/one.action")
    public String one(){

        return "main";
    }
    @RequestMapping("two.action")
    public String two(){
        //forward关键字可以屏蔽前缀和后缀的拼接
        return "forward:other.action";
    }
    @RequestMapping("/three.action")
    public String three(){
        //redirect关键字可以屏蔽字符创的拼接，
        return "redirect:/admin/main.jsp";
    }
    @RequestMapping("/four.action")
    public String four(){

        return "redirect:other.action";
    }
}
