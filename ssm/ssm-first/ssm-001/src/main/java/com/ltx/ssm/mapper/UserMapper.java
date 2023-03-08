package com.ltx.ssm.mapper;

import com.ltx.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 多条件查询，根据姓名和性别进行查询，并且进行分页显示
     * @param userName 用户姓名
     * @param userSex  用户性别
     * @param startRow  起始行
     * @return
     */
    List<User> selectUserPage(@Param("userName") String userName,
                              @Param("userSex") String userSex,
                              @Param("startRow") int startRow);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int createUser(User user);

    /**
     * 根据主键删除用户
     * @param userId
     * @return
     */
    int deleteUserById(String userId);

    /**
     * 获取查询的总记录条数
     * @param userName
     * @param userSex
     * @return
     */
    int getRowCount(@Param("userName") String userName, @Param("userSex") String userSex);
}
