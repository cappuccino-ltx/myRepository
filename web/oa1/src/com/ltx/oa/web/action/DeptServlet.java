package com.ltx.oa.web.action;

import com.ltx.oa.util.DBUtil;
import com.ltx.oa.web.bean.Dept;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dept/list","/dept/add","/dept/delete","/dept/detail","/dept/edit"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if (servletPath.equals("/dept/list")) {
            doList(request,response);
        }
        if (servletPath.equals("/dept/add")) {
            doAdd(request,response);
        }
        if (servletPath.equals("/dept/delete")) {
            dodelete(request,response);
        }
        if (servletPath.equals("/dept/detail")) {
            doDetail(request,response);
        }
        if (servletPath.equals("/dept/edit")) {
            //doEdit(request,response);
            if (request.getMethod().equals("GET")){
                doEditGet(request,response);
            }else if(request.getMethod().equals("POST")){
                doEditPost(request,response);
            }
        }

    }

    private void doEditGet(HttpServletRequest request, HttpServletResponse response) {
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
                Dept dept = new Dept(deptno, dname, loc);
                request.setAttribute("dept",dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.close(conn,ps,rs);
        }
        try {
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doEditPost(HttpServletRequest request, HttpServletResponse response) {
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
        //request.getRequestDispatcher("/dept/list").forward(request,response);
        try {
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) {
        String no = request.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select deptno,dname,loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,no);
            rs = ps.executeQuery();
            if(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                Dept dept = new Dept(deptno,dname,loc);
                request.setAttribute("dept",dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.close(conn,ps,rs);
        }
        try {
            request.getRequestDispatcher("/detail.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void dodelete(HttpServletRequest request, HttpServletResponse response) {
        String contextPath = request.getContextPath();
        String deptno = request.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "delete from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
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
        try {
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //request.getRequestDispatcher("/dept/list").forward(request,response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
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

        //request.getRequestDispatcher("/dept/list").forward(request,response);
        try {
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    private void doList(HttpServletRequest request, HttpServletResponse response) {
        //String contextPath = request.getContextPath();
        //连接数据库，查询数据库表中的所有数据，
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Dept> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                Dept dept = new Dept(deptno,dname,loc);
                list.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.close(conn,ps,rs);
        }
        request.setAttribute("deptlist", list);
        try {
            request.getRequestDispatcher("/list.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
