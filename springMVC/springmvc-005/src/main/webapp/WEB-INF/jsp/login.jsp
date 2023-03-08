<%--
  Created by IntelliJ IDEA.
  User: 21085
  Date: 2023/2/17
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<br><br>
<br>
<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="提交"><br>
</form>
<br><br>
${news}

</body>
</html>
