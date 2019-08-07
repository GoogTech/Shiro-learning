package pers.huangyuhui.ss.bean;

import java.io.Serializable;

/**
 * @project: springboot-shiro
 * @description: 权限信息
 * @author: 黄宇辉
 * @date: 8/6/2019-11:04 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class Permission implements Serializable {

    private Integer pid;
    private String name;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}