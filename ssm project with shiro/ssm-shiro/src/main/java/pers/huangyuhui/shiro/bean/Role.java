package pers.huangyuhui.shiro.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * @project: ssm-shiro
 * @description: 角色信息
 * @author: 黄宇辉
 * @date: 8/10/2019-4:15 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class Role {

    private Integer rid;
    private String name;
    private Set<Permission> permissions = new HashSet<>();

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}