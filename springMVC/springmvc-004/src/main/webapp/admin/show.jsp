<%--
  Created by IntelliJ IDEA.
  User: 21085
  Date: 2023/2/17
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入核心标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--导入格式化标签库--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>show....</h2>
<br><br><br>
date:${date}

<br><br><br>
<h2>学生集合</h2>
<table width="800px" border="1">
    <tr>
        <th>姓名</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${list}" var="stu">
        <tr>
            <th>${stu.name}</th>
            <th>${stu.birthday} ------<fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate> </th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
