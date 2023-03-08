<%--
  Created by IntelliJ IDEA.
  User: 21085
  Date: 2022/12/4
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用oa系统</title>
</head>
<body>
    <center><h1>登录页面</h1></center>

    <%--<center><a href="<%=request.getContextPath()%>/dept/list">查看部门列表</a></center>--%>

    <%--
        我们需要写一个登录页面
        1、先设计一张t_user数据库表，用来存储用户的登录信息，
            drop table if exists t_user;

            create table t_user(
                id int primary key auto_increment,
                username varchar(255),
                userpwd varchar(255)
            );

            insert into t_user(username,userpwd) values("admin","123456");
            insert into t_user(username,userpwd) values("zhangsan","123456");
            commit;
            select * from t_user;
        2、开始设计页面表单，
        3、实现功能
    --%>
    <center>

        <hr>
       <%-- <%
            String tag = request.getParameter("tag");

            if(tag != null){
                if(tag.equals("false")){
        %>
        <script type="text/javascript">
            function fail(){
                alert("登陆失败！")
            }
            fail()
        </script>
        <%
                }
            }
        %>--%>


    <form action="${pageContext.request.contextPath}/user/login" method="post">
        登录账号：<input type="text" name="username"><br>
        登录密码：<input type="password" name="userpwd"><br>
        <input type="checkbox" name="noLogin" value="true">十天内免登录<br>
        <input type="submit" value="登录">
    </form>
    </center>

</body>
</html>
