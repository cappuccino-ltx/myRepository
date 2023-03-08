<%--
  Created by IntelliJ IDEA.
  User: 21085
  Date: 2023/2/16
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<br><br>

<h2>测试get和post请求</h2>
<br>
<a href="${pageContext.request.contextPath}/user/req.action">测试get请求</a><br>
<form action="${pageContext.request.contextPath}/user/req.action" method="post">
    <input type="submit" value="测试post方法">
</form>
<br><br>
<h2>1,第一种数据提交的方式，单个数据提交（散提交）</h2>
<form action="${pageContext.request.contextPath}/data/loose.action">
    姓名：<input type="text" name="username"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交"><br>
</form>
<br><br>
<h2>2,第二种数据提交的方式，对象封装数据提交</h2>
<form action="${pageContext.request.contextPath}/data/object.action" method="post">
    姓名：<input type="text" name="username"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交"><br>
</form>
<br><br>
<h2>3、动态占位符提交数据</h2>
<form action="${pageContext.request.contextPath}/data/three/张三/20.action">
    <input type="submit" value="提交">
</form>

<h2>4、映射名称不一致的时候，怎么接收数据</h2>
<form action="${pageContext.request.contextPath}/data/four.action">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交"><br>
</form>
<h2>5,手工提取</h2>
<form action="${pageContext.request.contextPath}/data/five.action">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
