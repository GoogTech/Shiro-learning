package pers.huangyuhui.ss.mapper;

import pers.huangyuhui.ss.bean.User;

import java.util.List;

/**
 * @project: springboot-shiro
 * @description: Dao层
 * @author: 黄宇辉
 * @date: 8/5/2019-11:25 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public interface UserMapper {

    /**
     * @description: 根据用户名获取指定的用户信息
     * @param: username
     * @date: 2019-08-06 5:24 PM
     * @return: pers.huangyuhui.ss.bean.User
     */
    User findByName(String username);
}