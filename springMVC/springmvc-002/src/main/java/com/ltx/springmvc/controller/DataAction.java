package com.ltx.springmvc.controller;

import com.ltx.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/data")
@Controller
public class DataAction {
    /**
     *  前端表单中用的什么属性名，则在后端方法中定义同样的参数名，则可以接受数据
     */
    @RequestMapping("/loose.action")
    public String looseSub(String username, int age){
        System.out.println("username="+username+" age=" + age);
        return "main";
    }

    /**
     *  使用实体类便可以接受前端传来的数据，实体类中的属性名需要与前端的属性名一致，且提供set get方法
     */
    @RequestMapping("/object.action")
    public String objectSub(User user){
        System.out.println(user);
        return "main";
    }

    /**
     *  使用@PathVariable注解来提取路径上的数据，用的比较少
     */
    @RequestMapping("/three/{name}/{age}.action")
    public String three(@PathVariable("name") String name, @PathVariable("age") int age){
        System.out.println(name + "," + age);
        return "main";
    }

    /**
     *  当前端的属性名和后端的属性名对应不上的时候，可以使用@RequestParam注解来声明属性映射关系
     */
    @RequestMapping("/four.action")
    public String four(@RequestParam("name") String username, @RequestParam("age") int userage){
        System.out.println(username + "," + userage);
        return "main";
    }

    @RequestMapping("/five.action")
    public String five(HttpServletRequest request){
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println(name + "," + age);
        return "main";
    }
}
