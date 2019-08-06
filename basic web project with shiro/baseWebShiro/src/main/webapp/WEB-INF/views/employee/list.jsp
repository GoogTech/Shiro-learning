<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>员工列表</title>
</head>
<body>
<center>
    <h1>员工列表</h1>
    <a href="${pageContext.request.contextPath}/employee?cmd=input">新增</a>
    <br>
    <table border="1">
        <tbody>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>年龄</th>
            <th></th>
        </tr>
        <tr>
            <td>1</td>
            <td>yubuntu0109</td>
            <td>3083968068@qq.com</td>
            <td>21</td>
            <td>
                <a href="${pageContext.request.contextPath}/employee?cmd=input&id=1">编辑</a>
                <a href="${pageContext.request.contextPath}/employee?cmd=delete">删除</a>
            </td>
        </tr>
        </tbody>
    </table>
</center>
</body>
</html>