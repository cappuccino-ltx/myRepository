package com.ltx.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *  关于jdbc中事务的处理
 *      conn.setAutoCommit(false);//将自动提交改为手动提交（可以理解为开启事务）
 *      conn.commit();//提交事务
 *      conn.rollback();//回滚事务
 */
/*
        模拟转账：
        sql脚本：
            drop table if exists t_act;
            create table t_act(
                actno int primary key,
                name varchar(255),
                balance double(7,2)
            );

            insert into t_act(actno,name,balance) values(111,'zhangsan',10000);
            insert into t_act(actno,name,balance) values(222,'lisi',0);
 */
public class JDBCTest03 {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ms","root","j5063107544338");
            //开启事务
            conn.setAutoCommit(false);
            //获取数据库预操作对象
            String sql = "update t_act set balance = ? where actno = ?";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,5000);
            ps.setInt(2,111);
            int count = ps.executeUpdate();
            ps.setDouble(1,5000);
            ps.setInt(2,222);
            count += ps.executeUpdate();
            System.out.println(count == 2 ? "转账成功！" : "转账失败！");
            //能执行到此处说明没有异常发生，就提交事务
            conn.commit();
        } catch (ClassNotFoundException e) {
            //出现异常，就回滚事务
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        } catch (SQLException e) {
            //出现异常，就回滚事务
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally{
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
    }
}
