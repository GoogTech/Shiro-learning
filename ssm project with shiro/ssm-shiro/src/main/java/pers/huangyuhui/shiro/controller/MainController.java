package pers.huangyuhui.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: ssm-shiro
 * @description: 用户主页控制器
 * @author: 黄宇辉
 * @date: 8/10/2019-12:05 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
@Controller
public class MainController {

    /**
     * @description: 跳转到学生信息管理页
     * @date: 2019-08-11 8:52 AM
     * @return: java.lang.String
     */
    @RequestMapping("/stuListView")
    public String goStuView() {
        return "/view/info/student/student-list";
    }

    /**
     * @description: 跳转到教师信息管理页
     * @date: 2019-08-11 8:52 AM
     * @return: java.lang.String
     */
    @RequestMapping("/teaListView")
    public String goTeaListView() {
        return "/view/info/teacher/teacher-list";
    }

    /**
     * @description: 跳转到无权限提示页
     * @date: 2019-08-11 8:52 AM
     * @return: java.lang.String
     */
    @RequestMapping("/unauthorizedView")
    public String goUnauthorizedView() {
        return "/view/tips/unauthorized";
    }

}