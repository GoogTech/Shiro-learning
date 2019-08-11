package pers.huangyuhui.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.huangyuhui.shiro.bean.User;
import pers.huangyuhui.shiro.dao.UserMapper;
import pers.huangyuhui.shiro.service.UserService;

/**
 * @project: ssm-shiro
 * @description: TODO
 * @author: 黄宇辉
 * @date: 8/10/2019-4:11 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }
}