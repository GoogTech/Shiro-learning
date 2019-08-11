package pers.huangyuhui.shiro.bean;

/**
 * @project: ssm-shiro
 * @description: 权限信息
 * @author: 黄宇辉
 * @date: 8/10/2019-4:14 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class Permission {

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
