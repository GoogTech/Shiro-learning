package pers.huangyuhui.shiro.service;

import pers.huangyuhui.shiro.bean.User;

/**
 * @project: ssm-shiro
 * @description: Service层
 * @author: 黄宇辉
 * @date: 8/10/2019-4:11 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface UserService {

    /**
     * @description: 根据用户名获取指定的用户信息
     * @param: username
     * @date: 2019-08-11 8:55 AM
     * @return: pers.huangyuhui.shiro.bean.User
     */
    User findByName(String username);
}
