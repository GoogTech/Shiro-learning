package pers.huangyuhui.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: springboot-shiro
 * @description: 用户主页控制器
 * @author: 黄宇辉
 * @date: 8/5/2019-8:13 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
@Controller
public class MainController {

    /**
     * @description: 跳转到学生信息管理页
     * @date: 2019-08-06 5:22 PM
     * @return: java.lang.String
     */
    @RequestMapping("/stuListView")
    public String goStuListView() {
        return "info/student/student-list";
    }

    /**
     * @description: 跳转到教师信息管理页
     * @date: 2019-08-06 5:23 PM
     * @return: java.lang.String
     */
    @RequestMapping("/teaListView")
    public String goTeaListView() { return "info/teacher/teacher-list"; }
}