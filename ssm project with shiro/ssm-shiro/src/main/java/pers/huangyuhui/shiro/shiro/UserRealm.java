package pers.huangyuhui.shiro.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import pers.huangyuhui.shiro.bean.Permission;
import pers.huangyuhui.shiro.bean.Role;
import pers.huangyuhui.shiro.bean.User;
import pers.huangyuhui.shiro.service.UserService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @project: ssm-shiro
 * @description: 配置自定义Realm
 * @author: 黄宇辉
 * @date: 8/10/2019-1:11 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * @description: 授权认证:提供用户信息,返回权限信息
     * @param: principals
     * @date: 2019-08-11 7:50 AM
     * @return: org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.err.println("------------> 授权认证 ------------>");
        //获取当前登录的用户信息
        Subject currentUser = SecurityUtils.getSubject();
        User u = (User) currentUser.getPrincipal();
        //从数据库中获取用户所拥有的角色及权限信息
        User user = userService.findByName(u.getUsername());
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用于存储用户的角色及权限信息
            Collection<String> rolesCollection = new HashSet<>();
            Collection<String> permissionsCollection = new HashSet<>();
            Set<Role> roles = user.getRoles(); //获取用户Role的Set集合
            //通过遍历用户所拥有的角色,来获取其对应的权限信息
            for (Role role : roles) {
                rolesCollection.add(role.getName()); //将每一个role的name封装到集合中
                Set<Permission> permissionSet = role.getPermissions(); //获取每一个role所对应的permission的set集合
                //遍历用户所拥有的权限信息
                for (Permission permission : permissionSet) {
                    permissionsCollection.add(permission.getName()); //将每一个permission的name封装到集合中
                }
                info.addStringPermissions(permissionsCollection); //为用户授权
            }
            info.addRoles(rolesCollection); //为用户授予角色
            System.out.println("[roles]------------>" + rolesCollection.toString());
            System.out.println("[permissions]------------>" + permissionsCollection.toString());
            return info;
        }
        return null;

    }

    /**
     * @description: 登录认证:提供帐户信息,返回认证信息
     * @param: authenticationToken
     * @date: 2019-08-11 7:51 AM
     * @return: org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.err.println("------------> 开始认证 ------------>");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //从数据库中获取用户信息
        User user = userService.findByName(token.getUsername());
        System.out.println("[user]------------>" + user);
        //验证账户信息
        if (user == null) {
            return null; //it's will be throw a UnknownAccountException
        }
        //验证密码信息(盐值:ByteSource.Util.bytes(user.getUsername()))
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getUsername()), this.getName());
    }
}