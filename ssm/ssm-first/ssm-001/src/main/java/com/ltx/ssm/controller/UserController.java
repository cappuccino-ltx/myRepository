package com.ltx.ssm.controller;

import com.ltx.ssm.pojo.User;
import com.ltx.ssm.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    public static final int PAGE_SIZE = 5;
    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName,String userSex, Integer page){
        int startRow = 0;
        if (page != null) {
            startRow = (page - 1) * PAGE_SIZE;
        }
        return userService.selectUserPage(userName,userSex,startRow);
    }

    @ResponseBody
    @RequestMapping("/getRowCount")
    public int getRowCount(String userName, String userSex){
        return userService.getRowCount(userName,userSex);
    }

    @ResponseBody
    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId){
        return userService.deleteUserById(userId);
    }

    @ResponseBody
    @RequestMapping("/createUser")
    public int createUser(User user){
        String uId = System.currentTimeMillis()+"";
        user.setUserId(uId);
        return userService.createUser(user);
    }


}
