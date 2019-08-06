<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 引入Shiro标签 -->
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>main</title>
    <link type="text/css" href="${pageContext.request.contextPath}/static/style/main_css.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/main.js"></script>
</head>
<body>
<div class="top">
    <div class="logo">
        <h3 style="margin-left: 15px">Shiro整合基本web | 一个简单的用户权限控制案例</h3>
    </div>
    <div class="userinfo">
        当前登录用户 : <shiro:principal/>
        <a href="${pageContext.request.contextPath}/logout">注销</a>
    </div>
</div>
<div class="center">
    <div class="center_left">
        <ul>
            <li>
                <a href="javascript:;" class="changePage" data-url="/employee">员工管理</a>
            </li>
            <li>
                <a href="javascript:;" class="changePage" data-url="/department">部门管理</a>
            </li>
        </ul>
    </div>
    <div class="center_content">
        <iframe name="right" id="rightMain" src="${pageContext.request.contextPath}/welcome.jsp"
                frameborder="no" scrolling="auto" width="100%" height="100%" allowtransparency="true">
        </iframe>
    </div>
</div>
</body>
</html>