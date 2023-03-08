package com.ltx.oa.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        String servletPath = request.getServletPath();
        if((session != null && session.getAttribute("user") != null)
            || "/welcome".equals(servletPath) || "/index.jsp".equals(servletPath)
                || "/user/logout".equals(servletPath) || "/user/login".equals(servletPath)
        ){
            filterChain.doFilter(request,response);
        }else{
            //重定向到登录页面
            response.sendRedirect(request.getContextPath());
        }
    }
}
