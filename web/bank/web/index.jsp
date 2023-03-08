<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>银行转账</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/transfer" method="post">
    转出账户：<input type="text" name="fromAct"><br>
    转入账户：<input type="text" name="toAct"><br>
    转入金额：<input type="text" name="money"><br>
    <input type="submit" value="确定">
  </form>
  </body>
</html>
