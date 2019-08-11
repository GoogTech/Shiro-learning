package pers.huangyuhui.shiro.dao;

import pers.huangyuhui.shiro.bean.User;

/**
 * @project: ssm-shiro
 * @description: DAO层
 * @author: 黄宇辉
 * @date: 8/10/2019-4:10 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface UserMapper {

    /**
     * @description: 根据用户名获取指定的用户信息
     * @param: username
     * @date: 2019-08-11 8:55 AM
     * @return: pers.huangyuhui.shiro.bean.User
     */
    User findByName(String username);
}