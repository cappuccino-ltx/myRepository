
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>信息修改</title>
</head>
<body>
<h5>
    欢迎[${username}]
    <a href="${pageContext.request.contextPath}/user/logout">安全退出</a>
</h5>
    <h1 align="center">修改部门</h1>
    <hr>
    <center>
          <form action="<%=request.getContextPath()%>/dept/edit" method="post">
                <font size="5px" >部门编号：</font><input type="text" value="${dept.deptno}" name="deptno" readonly />
                <br>
                <font size="5px" >部门名称：</font><input type="text" value="${dept.dname}" name="dname" />
                <br>
                <font size="5px" >所在地区：</font><input type="text" value="${dept.loc}" name="loc" />
                <br>
                <input type="submit" value="提交" style="width:80px;height:40px">
                <input type="button" value="返回" style="width:80px;height:40px" onclick="window.history.back()">
          </form>
    </center>
</body>
</html>
