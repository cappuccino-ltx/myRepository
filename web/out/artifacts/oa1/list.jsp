<%@ page import="com.ltx.oa.web.bean.Dept" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>部门列表</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type='text/javascript'>
    function del(no){
        if(window.confirm('确定要删除该数据吗？')){
            document.location.href='${pageContext.request.contextPath}/dept/delete?deptno='+no
        }
    }
    </script>
</head>
<body>
    <h5>
        欢迎[${username}]
        <a href="user/logout">安全退出</a>
        在线人数：${userCount}
    </h5>
    <h1 align='center'>部门列表</h1>
    <hr>
    <table align='center' width='60%' border='1' cellspacing='0' cellpadding='10'>
        <tr>
            <th>序号</th>
            <th>部门编号</th>
            <th>部门名</th>
            <th>所在地区</th>
            <th>操作</th>
        </tr>
       <%-- <%
            List<Dept> list = (List<Dept>) request.getAttribute("deptlist");
            int i = 0;
            for (Dept dept:list) {
                String deptno = dept.getDeptno();
                String dname = dept.getDname();
                String loc = dept.getLoc();

        %>--%>
        <c:forEach items="${deptlist}" var="dept" varStatus="deptStatus">
            <tr align='center'>
                <td>${deptStatus.count}</td>
                <td>${dept.deptno}</td>
                <td>${dept.dname}</td>
                <td>${dept.loc}</td>
                <td>
                    <a href='${pageContext.request.contextPath}/dept/detail?deptno=${dept.deptno}'>详情</a>
                    <a href='${pageContext.request.contextPath}/dept/edit?deptno=${dept.deptno}'>修改</a>
                    <a href='javascript:void(0)' onclick='del(${dept.deptno})'>删除</a>
                </td>
            </tr>
        </c:forEach>

        <%--<%
            }
        %>--%>

    </table>
    <center><a href='${pageContext.request.contextPath}/add.jsp' >添加部门</a></center>
</body>
</html>
