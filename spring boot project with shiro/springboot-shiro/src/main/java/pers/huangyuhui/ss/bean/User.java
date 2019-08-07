package pers.huangyuhui.ss.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @project: springboot-shiro
 * @description: 用户信息
 * @author: 黄宇辉
 * @date: 8/5/2019-9:25 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class User implements Serializable {

    private Integer uid;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}