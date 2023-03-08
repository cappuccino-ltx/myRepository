package com.ltx.bank.test;

import com.ltx.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSM {
    @Test
    public void testSM(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act001", "act002", 10000L);
            System.out.println("转账成功！");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
