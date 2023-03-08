<%--
  Created by IntelliJ IDEA.
  User: 21085
  Date: 2023/2/16
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc</title>
    <script src="js/jquery-3.6.1.js"></script>
</head>
<body>

<br><br><br>
<a href="javascript:showStu()"><h2>访问数据库中的学生集合</h2></a>
<br>
<div id="mydiv">
    等待数据库返回信息
</div>
<script type="text/javascript">
        function showStu(){
            //使用jQuery封装的ajax方法，发送请求
            $.ajax({
                url:"${pageContext.request.contextPath}/list.action",
                type:"get",
                dataType:"json",
                success:function(stuList){
                    var s = "";
                    $.each(stuList, function(i,stu){
                        s += stu.name + "---->" + stu.age +"<br>";
                    });
                    $("#mydiv").html(s);
                }
            });
        }

</script>
</body>
</html>
