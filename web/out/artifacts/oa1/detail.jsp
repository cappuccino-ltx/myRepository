
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门详情</title>
</head>
<body>
<h5>
    欢迎[${username}]
    <a href="${pageContext.request.contextPath}/user/logout">安全退出</a>
</h5>
    <h1 align='center'>部门详情</h1>
    <hr>
    <center>
      <font size='5px'>部门编号：${dept.deptno}</font><br>
      <font size='5px'>部门名称：${dept.dname}</font><br>
      <font size='5px'>所在地区：${dept.loc}</font><br>
      <input type='button' value='返回' style='width:80px;height:40px' onclick='window.history.back()'>
    </center>


</body>
</html>
