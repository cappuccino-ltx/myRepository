package com.ltx.spring.test;

import com.ltx.spring.SpringConfig;
import com.ltx.spring.bean.User;
import com.ltx.spring.service.UserService;
import com.ltx.spring.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentTest {

    @Test
    public void testConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServlet userServlet = context.getBean("userServlet", UserServlet.class);
        userServlet.user();
    }

    @Test
    public void testAutoWired(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        UserServlet userServlet = applicationContext.getBean("userServlet", UserServlet.class);
        userServlet.user();
    }
    @Test
    public void testComponent(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        System.out.println(userService);

        UserServlet userServlet = applicationContext.getBean("userServlet", UserServlet.class);
        System.out.println(userServlet);


    }
}
