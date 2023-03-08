package com.ltx.ssm.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CorsFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");                                      //允许所有网址发来的请求
        response.addHeader("Access-Control-Allow-Methods", "REQUEST,GET,POST,PUT,DELETE,PATCH,HEAD");//允许的请求方法
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");                          //,X-Requested-With,auth_token
        response.addHeader("Access-Control-Max-Age", "1800");//30 min
        filterChain.doFilter(request, response);
    }
}
