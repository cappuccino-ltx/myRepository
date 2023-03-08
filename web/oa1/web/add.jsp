
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门信息</title>
</head>
<body>
<h5>
    欢迎[${username}]
    <a href="${pageContext.request.contextPath}/user/logout">安全退出</a>
</h5>
    <h1 align="center">新增部门</h1>
    <hr>
    <center>
        <form action="${pageContext.request.contextPath}/dept/add"  method="post">
          <font size="5px" >部门编号：</font><input type="text"  name="deptno"/>
          <br>
          <font size="5px" >部门名称：</font><input type="text" name="dname" />
          <br>
          <font size="5px" >所在地区：</font><input type="text" name="loc" />
          <br>
          <input type="submit" value="提交" id='submit' style="width:80px;height:40px">
          <input type="button" value="返回" style="width:80px;height:40px" onclick="window.history.back()">
        </form>
    </center>

</body>
</html>
