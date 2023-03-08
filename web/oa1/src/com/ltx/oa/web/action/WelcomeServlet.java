package com.ltx.oa.web.action;

import com.ltx.oa.util.DBUtil;
import com.ltx.oa.web.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String userpwd = null;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")){
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("userpwd")){
                    userpwd = cookie.getValue();
                }
            }
        }
        if(username != null && userpwd != null){
            //验证密码是否正确
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                conn = DBUtil.getConnection();
                String sql = "select userpwd from t_user where username = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                rs = ps.executeQuery();
                if(rs.next()){
                    if(userpwd.equals(rs.getString("userpwd"))){
                        HttpSession session = request.getSession();
                        User user = new User(username, userpwd);
                        session.setAttribute("user", user);
                        response.sendRedirect(request.getContextPath() + "/dept/list");
                    }
                }else{
                    //登陆失败的话也回到登录页面
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            //回到登录页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}
