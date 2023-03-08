package com.ltx.springmvc.controller;


import com.ltx.springmvc.pojo.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DateAction {

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 注册一个全局的日期处理注解
     * @param dateBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder dateBinder){
        dateBinder.registerCustomEditor(Date.class,new CustomDateEditor(sf,true));
    }

    @RequestMapping("/date.action")
    public String date(HttpServletRequest request, Date date){

        System.out.println(date);
        System.out.println(sf.format(date));

        request.setAttribute("date",sf.format(date));

        return "show";
    }

    @RequestMapping("/list.action")
    public String list(HttpServletRequest request) throws ParseException {
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student("张三", sf.parse("2001-01-01"));
        Student stu2 = new Student("李四", sf.parse("2002-02-01"));
        Student stu3 = new Student("王五", sf.parse("2004-06-01"));
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        request.setAttribute("list",list);
        return "show";
    }
}
