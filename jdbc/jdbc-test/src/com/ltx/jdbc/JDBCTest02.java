package com.ltx.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 模拟一个用户登录的功能
 *      准备数据库中的一张表，连接数据库，对比校验账户密码。
 *
 *
 *      其中，实现获取数据库操作对象的是preparedStatement(数据库预操作对象，)
 *      PreparedStatement 和 Statement 的区别
 *          1、Statement会产生SQL注入（也就是，用户输入的内容可能会对原本的SQL语句产生影响，从而影响程序的正常运行）
 *             PreparedStatement 解决了SQL注入问题，
 *          2、Statement,编译一次，执行一次，而PreparedStatement编译一次可执行多次；
 *          3、PreparedStatement相比于Statement在编译阶段会做类型的安全监测
 *
 */
public class JDBCTest02 {
    public static void main(String[] args){
        //初始化界面
        Map<String, String> userinfo = initUI();
        //校验账号密码
        boolean loginResult = login(userinfo);
        System.out.println(loginResult ? "登录成功！" : "登陆失败！");
    }
    /**
     * jdbc连接数据库，校验账号密码
     */
    private static boolean login(Map<String, String> userinfo) {
        boolean result = false;
        //连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet re = null;

        try {
            //1，注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2，获取连接，
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ms", "root", "j5063107544338");
            //3，获取数据库预操作对象
            ps = conn.prepareStatement("select * from t_user where username = ? and userpwd = ?");
            //4，执行sql语句
            ps.setString(1,userinfo.get("username"));
            ps.setString(2,userinfo.get("userpwd"));
            re = ps.executeQuery();
            //5，处理查询结果集
            if(re.next()){
                //System.out.println(re.getString("username") + re.getString("userpwd"));
                result = true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            //6，关闭资源
            if (re != null) {
                try {
                    re.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return result;
    }

    /**
     * UI获取账号密码
     * @return
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.print("用户名:");
        String username = s.nextLine();
        System.out.print("密码:");
        String userpwd = s.nextLine();
        Map<String, String> userinfo = new HashMap<>();
        userinfo.put("username", username);
        userinfo.put("userpwd", userpwd);
        return userinfo;
    }
}
