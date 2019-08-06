package pers.huangyuhui.shiro.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmd = req.getParameter("cmd");
        if ("input".equals(cmd)) {
            if (req.getParameter("id") != null) {
                req.setAttribute("name", "yubuntu0109");
                req.setAttribute("age", "21");
                req.setAttribute("email", "3083968068@qq.com");
                req.setAttribute("cmdType", "编辑");
            } else {
                req.setAttribute("cmdType", "新增");
            }
            req.getRequestDispatcher("/WEB-INF/views/employee/input.jsp").forward(req, resp);
        } else if ("savaOrUpdate".equals(cmd)) {
            // ······
        } else if ("delete".equals(cmd)) {
            // ······
        } else {
            req.getRequestDispatcher("/WEB-INF/views/employee/list.jsp").forward(req, resp);
        }
    }

}