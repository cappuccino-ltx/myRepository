package com.ltx.oa.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC 的工具类
 */
public class DBUtil {

    //将JDBC连接数据库的某些步骤进行封装

    private static ResourceBundle bundle = ResourceBundle.getBundle("properties.jdbc");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    //注册驱动
    static {
        //因为项目执行只需要注册一次驱动，所以将注册驱动的代码放在了静态代码快当中
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    //关闭连接
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
