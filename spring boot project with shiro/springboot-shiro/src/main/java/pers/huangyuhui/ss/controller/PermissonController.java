package pers.huangyuhui.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @project: springboot-shiro
 * @description: 权限请求控制器
 * @author: 黄宇辉
 * @date: 8/5/2019-2:44 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
@Controller
public class PermissonController {

    /**
     * @description: 跳转到权限提示页
     * @date: 2019-08-06 5:21 PM
     * @return: java.lang.String
     */
    @RequestMapping("/unauthorizedView")
    public String unauthorizedView() {
        return "tips/unauthorized";
    }
}