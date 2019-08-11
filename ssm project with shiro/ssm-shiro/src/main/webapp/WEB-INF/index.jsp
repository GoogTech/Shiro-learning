<%--
  User: 黄宇辉
  Date: 8/10/2019
  Time: 11:57 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!-- use EL-expression-->
<%@page isELIgnored="false" %>
<!-- use Shiro-tag -->
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">用户主页</h3>
<!-- /logout : 由Shiro提供的登录信息注销功能 -->
<span style="margin-left: 950px">
    当前用户 : <shiro:principal property="username"/>
    [
    <shiro:hasRole name="admin">管理员</shiro:hasRole>
    <shiro:hasRole name="teacher">教师</shiro:hasRole>
    <shiro:hasRole name="student">学生</shiro:hasRole>
    ]
    <a href="${pageContext.request.contextPath}/logout">注销</a>
</span>
<br>
<hr>
<!-- /teaListView : 访问该页面需要用户进行身份认证及'stuListView:view'权限 -->
学生信息管理页 : <a href="${pageContext.request.contextPath}/stuListView">进入</a><br>
<!-- /teaListtView : 访问该页面需要用户进行身份认证及'teacherView:view'权限 -->
教师信息管理页 : <a href="${pageContext.request.contextPath}/teaListView">进入</a>
</body>