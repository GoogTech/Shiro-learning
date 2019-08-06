package pers.huangyuhui.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.huangyuhui.ss.bean.User;
import pers.huangyuhui.ss.mapper.UserMapper;
import pers.huangyuhui.ss.service.UserService;

/**
 * @project: springboot-shiro
 * @description: TODO
 * @author: 黄宇辉
 * @date: 8/5/2019-11:37 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String username) { return userMapper.findByName(username); }
}