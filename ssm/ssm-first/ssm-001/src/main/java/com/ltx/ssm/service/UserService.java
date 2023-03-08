package com.ltx.ssm.service;

import com.ltx.ssm.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 分页查询
     * @param userName
     * @param userSex
     * @param startRow
     * @return
     */
    List<User> selectUserPage(String userName, String userSex, int startRow);

    int createUser(User user);

    int deleteUserById(String userId);

    int getRowCount(String userName, String userSex);
}
