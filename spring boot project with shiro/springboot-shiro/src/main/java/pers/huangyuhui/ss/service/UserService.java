package pers.huangyuhui.ss.service;

import pers.huangyuhui.ss.bean.User;

/**
 * @project: springboot-shiro
 * @description: Service层
 * @author: 黄宇辉
 * @date: 8/5/2019-11:35 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface UserService {

    /**
     * @description: 根据用户名获取指定的用户信息
     * @param: username
     * @date: 2019-08-06 5:28 PM
     * @return: pers.huangyuhui.ss.bean.User
     */
    User findByName(String username);
}