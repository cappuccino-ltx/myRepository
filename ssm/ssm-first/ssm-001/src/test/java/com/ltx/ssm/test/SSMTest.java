package com.ltx.ssm.test;

import com.ltx.ssm.pojo.User;
import com.ltx.ssm.service.UserService;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class SSMTest {
    @Resource(name = "userService")
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> users = userService.selectUserPage(null, null, 0);
        users.forEach(user -> System.out.println(user));
    }
    @Test
    public void testCreateUser(){
        int count = userService.createUser(new User("12345678912345678","身份证","12332121","杜依依","女","22","学生"));
        System.out.println(count);
    }
    @Test
    public void testDeleteUserById(){
        int i = userService.deleteUserById("12345678912345678");
        System.out.println(i);
    }
    @Test
    public void testGetRowCount(){
        int rowCount = userService.getRowCount(null, null);
        System.out.println(rowCount);
    }
}
