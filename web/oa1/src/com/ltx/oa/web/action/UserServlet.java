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

@WebServlet({"/user/login","/user/logout"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if(servletPath.equals("/user/login")){
            doLogin(request,response);
        }else if(servletPath.equals("/user/logout")){
            doLogout(request,response);
        }
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie: cookies) {
                    if("username".equals(cookie.getName()) || "userpwd".equals(cookie.getName())){
                        cookie.setMaxAge(0);
                        cookie.setPath(request.getContextPath());
                        response.addCookie(cookie);
                    }
                }
            }

            //跳转到登录页面
            try {
                response.sendRedirect(request.getContextPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) {
        String noLogin = request.getParameter("noLogin");
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String userpwd1 = "";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select userpwd from t_user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                userpwd1 = rs.getString("userpwd");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.close(conn,ps,rs);
        }
        //登录成功
        if(userpwd1.equals(userpwd)){
            HttpSession session = request.getSession();
            User user = new User(username,userpwd);
            session.setAttribute("user",user);
            if("true".equals(noLogin)){
                //十天内免登录
                Cookie cookie1 = new Cookie("username",username);
                Cookie cookie2 = new Cookie("userpwd", userpwd);
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            try {
                response.sendRedirect(request.getContextPath() + "/dept/list");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {//登录失败
            try {
                response.sendRedirect(request.getContextPath() + "/welcome");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
