package com.ltx.springmvc.controller;

import com.ltx.springmvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentAction {

    @RequestMapping("/list.action")
    @ResponseBody //处理ajax请求的注解
    public List<Student> list(){
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student("张三",20);
        Student stu2 = new Student("李四", 21);
        Student stu3 = new Student("王五", 22);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        return list;//mvc框架会在底层将集合自动转化为json格式的字符串
    }
}
