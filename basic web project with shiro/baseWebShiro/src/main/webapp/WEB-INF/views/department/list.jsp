<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 引入Shiro标签 -->
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>部门列表</title>
</head>
<body>
<center>
    <h2>部门列表</h2>
    <!-- 当用户具有department模块的‘add’权限时才显示此按钮 -->
    <shiro:hasPermission name="department:add">
        <a href="${pageContext.request.contextPath}/department?cmd=input">新增</a>
    </shiro:hasPermission>
    <br>
    <table border="1">
        <tbody>
        <tr>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>部门人数</th>
            <th>创建时间</th>
            <th>负责人</th>
            <th></th>
        </tr>
        <tr>
            <td>1</td>
            <td>研发部</td>
            <td>100</td>
            <td>2019-8-3</td>
            <td>yubuntu0109</td>
            <td>
                <!-- 当用户具有department模块的‘edit’权限时才显示此按钮 -->
                <shiro:hasPermission name="department:edit">
                    <a href="${pageContext.request.contextPath}/department?cmd=input&id=1">编辑</a>
                </shiro:hasPermission>
                <!-- 当用户具有department模块的‘del’权限时才显示此按钮 -->
                <shiro:hasPermission name="department:del">
                    <a href="${pageContext.request.contextPath}/department?cmd=delete">删除</a>
                </shiro:hasPermission>
            </td>
        </tr>
        </tbody>
    </table>
</center>
</body>
</html>