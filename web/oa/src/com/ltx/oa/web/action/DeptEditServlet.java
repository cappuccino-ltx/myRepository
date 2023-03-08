package com.ltx.oa.web.action;

import com.ltx.oa.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update dept set dname = ?,loc = ? where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException(e);
        }finally{
            DBUtil.close(conn,ps,null);
        }
        request.getRequestDispatcher("/dept/list").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset='utf-8'>");
        out.println("        <title>修改部门</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1 align='center'>修改部门</h1>");
        out.println("        <hr>");
        out.println("        <center>");
        out.println("        <form action='/oa/dept/edit' method='post'>");



        String deptno = request.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select deptno,dname,loc from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs = ps.executeQuery();
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.println("<font size='5px' >部门编号：</font><input type='text'  name='deptno' value='"+deptno+"' readonly />");
                out.println("<br>");
                out.println("<font size='5px' >部门名称：</font><input type='text' name='dname' value='"+dname+"'/>");
                out.println("<br>");
                out.println("<font size='5px' >所在地区：</font><input type='text' name='loc' value='"+loc+"'/>");
                out.println("<br>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.close(conn,ps,rs);
        }

        out.println("            <input type='submit' value='提交' style='width:80px;height:40px'>");
        out.println("            <input type='button' value='返回' style='width:80px;height:40px' onclick='window.history.back()'>");
        out.println("        </form>");
        out.println("        </center>");
        out.println("    </body>");
        out.println("</html>");
    }
}
