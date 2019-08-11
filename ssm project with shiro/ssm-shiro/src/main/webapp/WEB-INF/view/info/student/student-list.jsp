<%--
  User: 黄宇辉
  Date: 8/10/2019
  Time: 11:58 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!-- use EL-expression -->
<%@page isELIgnored="false" %>
<!-- use Shiro-tag -->
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">学生信息管理页面</h3>
<hr>
<div align="center">
    <!-- 添加学生信息功能需要用户拥有'stuListView:add'权限 -->
    <shiro:hasPermission name="stuListView:add">
        <a href="${pageContext.request.contextPath}/stuListView/add">新增</a>
    </shiro:hasPermission>
    <table border="1px">
        <tbody>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>专业</th>
            <th>班级</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <tr>
            <th>0000001</th>
            <th>学生001</th>
            <th>男</th>
            <th>20</th>
            <th>软件工程</th>
            <th>1702班</th>
            <th>15111111111</th>
            <th>
                <!-- 编辑学生信息功能需要用户拥有'stuListView:edit'权限 -->
                <shiro:hasPermission name="stuListView:edit">
                    <a href="${pageContext.request.contextPath}/stuListView/edit">编辑</a>
                </shiro:hasPermission>
                <!-- 删除学生信息功能需要用户拥有'stuListView:delete'权限 -->
                <shiro:hasPermission name="stuListView:delete">
                    <a href="${pageContext.request.contextPath}/stuListView/delect">删除</a>
                </shiro:hasPermission>
            </th>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>