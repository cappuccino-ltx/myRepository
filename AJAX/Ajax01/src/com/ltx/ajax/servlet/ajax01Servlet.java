package com.ltx.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/ajax/request01","/ajax/request02","/ajax/request03"})
public class ajax01Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if("/ajax/request01".equals(path)){
            String method = request.getMethod();
            if("GET".equals(method)){
                doGet01(request,response);
            }if("POST".equals(method)){
                //doPost01(request,response);
            }
        }else if("/ajax/request02".equals(path)){
            String method = request.getMethod();
            if("GET".equals(method)){
                doGet02(request,response);
            }
            if("POST".equals(method)){
                //doPost02(request,response);
            }
        }else if("/ajax/request03".equals(path)){
            String method = request.getMethod();
            if("GET".equals(method)){
                //doGet03(request,response);
            }
            if("POST".equals(method)){
                doPost03(request,response);
            }
        }
    }

    private void doPost03(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");

        out.print("username="+username+" userpwd="+userpwd);
    }

    private void doGet02(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        out.print("username="+username+" userpawd="+userpwd);
    }

    private void doGet01(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;chatset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<font color='red'>hello Ajax</font>!");
    }

}
