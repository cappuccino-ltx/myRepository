<%--
  Created by IntelliJ IDEA.
  User: 21085
  Date: 2023/2/16
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>测试四种跳转方式</h2>

<a href="${pageContext.request.contextPath}/one.action">默认：请求转发</a><br>
<a href="${pageContext.request.contextPath}/two.action">请求转发action</a><br>
<a href="${pageContext.request.contextPath}/three.action">重定向</a><br>
<a href="${pageContext.request.contextPath}/four.action">重定向action</a><br>

<br><br>
<a href="${pageContext.request.contextPath}/data.action">访问服务器，携带数据进行跳转</a>

<br><br>
<form action="${pageContext.request.contextPath}/date.action">
    <input type="date" name="date">
    <input type="submit" value="提交">
</form>

<a href="${pageContext.request.contextPath}/list.action">显示集合中对象成员的生日</a>
</body>
</html>
