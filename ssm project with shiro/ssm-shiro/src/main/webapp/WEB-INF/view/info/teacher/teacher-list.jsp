<%--
  User: 黄宇辉
  Date: 8/10/2019
  Time: 11:58 AM
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
<h3 align="center">教师信息管理页面</h3>
<hr>
<div align="center">
    <shiro:hasPermission name="teaListView:add">
        <a href="${pageContext.request.contextPath}/teaListView/add">新增</a>
    </shiro:hasPermission>
    <table border="1px">
        <tbody>
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>职位</th>
            <th>学位</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <tr>
            <th>0000001</th>
            <th>教师001</th>
            <th>男</th>
            <th>40</th>
            <th>Java EE讲师</th>
            <th>硕士</th>
            <th>15111111111</th>
            <th>
                <shiro:hasPermission name="teaListView:edit">
                    <a href="${pageContext.request.contextPath}/teaListView/edit">编辑</a>
                </shiro:hasPermission>
                <shiro:hasPermission name="teaListView:delete">
                    <a href="${pageContext.request.contextPath}/teaListView/delect">删除</a>
                </shiro:hasPermission>
            </th>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
