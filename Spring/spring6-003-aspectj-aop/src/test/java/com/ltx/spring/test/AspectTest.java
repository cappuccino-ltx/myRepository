package com.ltx.spring.test;

import com.ltx.spring.service.UserService;
import com.ltx.spring.service.UserTransfer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {
    @Test
    public void testTransactionAspect(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserTransfer userTransfer = context.getBean("userTransfer", UserTransfer.class);
        userTransfer.transfer();
    }

    @Test
    public void testLogAspect(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.login();
    }
}
