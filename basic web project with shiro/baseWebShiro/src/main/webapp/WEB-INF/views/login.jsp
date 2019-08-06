<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>login</title>
    <style type="text/css">
        h3 {
            text-align: center;
        }

        #main {
            width: 600px;
            margin-left: 480px;
        }

        #main tr {
            height: 40px;
        }

        #main tr td {
            width: 20px;
        }

        #main tr td input {
            width: 200px;
        }

        span {
            font-size: 13px;
            color: red;
        }

        .buttom {
            text-align: center;
            padding-top: 25px;
        }

        .buttom .login {
            margin-right: 40px;
        }
    </style>
</head>
<body>
<h3>用户登录页</h3>
<hr/>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table id="main">
        <tr>
            <td>账号</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password"/>
                <span>${errorMsg}</span>
            </td>
        </tr>
    </table>
    <div class="buttom">
        <input class="login" type="submit" value="登录"/>
        <input type="reset" value="重置"/>
    </div>
</form>
</body>
</html>