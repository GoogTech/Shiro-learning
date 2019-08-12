<%--
  User: 黄宇辉
  Date: 8/10/2019
  Time: 11:59 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!-- use EL-expression-->
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align="center">用户登录页面</h2>
<hr>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/login">
        账户 : <input type="text" name="username"><br>
        密码 : <input type="password" name="password" style="margin-top: 20px"><br>
        记住我 : <input type="checkbox" name="rememberMe"/>
        <input type="submit" style="margin-top: 20px" value="登录">
        <span style="color: red">${errorMsg}</span>
    </form>
</div>
</body>
</html>