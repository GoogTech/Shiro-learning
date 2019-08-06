package pers.huangyuhui.shiro.web;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果登录失败,则从request中获取认证异常信息,shiro异常类的全限定名为:shiroLoginFailure
        String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
        //根据Shiro返回的异常类,抛出指定的异常信息
        if (exceptionClassName != null) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                req.setAttribute("errorMsg", "账号不存在 !");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                req.setAttribute("errorMsg", "账号/密码信息错误 !");
            } else {
                req.setAttribute("errorMsg", "其它异常信息 ...");
            }
        }
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

}