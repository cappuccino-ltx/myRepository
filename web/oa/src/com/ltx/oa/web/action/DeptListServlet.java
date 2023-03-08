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

public class DeptListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置相应的内容类型以及字符集，防止中文乱码问题，
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //这些固定不变
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("	<head>");
        out.println("		<meta charset='utf-8'>");
        out.println("		<title>lsit</title>");

        out.println("<script type='text/javascript'>");
        out.println("      function del(no){");
        out.println("         if(window.confirm('确定要删除该数据吗？')){");
        out.println("            document.location.href='/oa/dept/delete?deptno='+no");
        out.println("        }");
        out.println("    }");
		out.println("</script>");

        out.println("	</head>");
        out.println("	<body>");
        out.println("		<h1 align='center'>部门列表</h1>");
        out.println("		<hr>");
        out.println("		<!--cellspacing='0',设置格间距-->");
        out.println("		<!--cellpadding='10',设置格边距-->");
        out.println("		<table align='center' width='60%' border='1' cellspacing='0' cellpadding='10'>");
        out.println("			<tr>");
        out.println("				<th>序号</th>");
        out.println("				<th>部门编号</th>");
        out.println("				<th>部门名</th>");
        out.println("				<th>所在地区</th>");
        out.println("				<th>操作</th>");
        out.println("			</tr>");

        String contextPath = request.getContextPath();
        //连接数据库，查询数据库表中的所有数据，
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while(rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.println("			<tr align='center'>");
                out.println("				<td>"+(++i)+"</td>");
                out.println("				<td>"+deptno+"</td>");
                out.println("				<td>"+dname+"</td>");
                out.println("				<td>"+loc+"</td>");
                out.println("				<td>");
                out.println("					<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
                out.println("					<a href='/oa/dept/edit?deptno="+deptno+"'>修改</a>");
                out.println("					<a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>");
                out.println("				</td>");
                out.println("			</tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.close(conn,ps,rs);
        }

        out.println("		</table>");
        out.println("		<center><a href='/oa/add.html' >添加部门</a></center>");
        out.println("	</body>");
        out.println("</html>");
    }
}
