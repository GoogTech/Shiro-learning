package pers.huangyuhui.ss.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @project: springboot-shiro
 * @description: Shiro配置信息
 * @author: 黄宇辉
 * @date: 8/5/2019-7:41 AM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
@Configuration
public class ShiroConfig {

    /**
     * @description: 配置过滤器
     * @param: securityManager
     * @date: 2019-08-05 7:59 AM
     * @return: org.apache.shiro.spring.web.ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置自定义过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(getFilterChainDefinitionMap());
        //设置用户登录页,默认: http://localhost:8080/login.jsp
        shiroFilterFactoryBean.setLoginUrl("/loginView");
        //设置用户未授权操作提示页
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorizedView");
        return shiroFilterFactoryBean;
    }

    /**
     * @description: 初始化自定义Realm
     * @param: credentialsMatcher
     * @date: 2019-08-05 7:50 AM
     * @return: pers.huangyuhui.ss.shiro.UserRealm
     */
    @Bean
    public UserRealm getUserRealm(CredentialsMatcher credentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        //使用credentialsMatcher加密算法类来验证密文
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    /**
     * @description: 安全事务管理器
     * @param: credentialsMatcher
     * @date: 2019-08-05 7:53 AM
     * @return: org.apache.shiro.web.mgt.DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    @DependsOn("credentialsMatcher")
    public SecurityManager getSecurityManager(CredentialsMatcher credentialsMatcher) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(getUserRealm(credentialsMatcher)); //关联realm
        return defaultWebSecurityManager;
    }

    /**
     * @description: 哈希密码比较器:比较用户登录时输入的密码,跟数据库密码配合盐值salt解密后是否一致
     * @date: 2019-08-05 9:01 PM
     * @return: org.apache.shiro.authc.credential.HashedCredentialsMatcher
     */
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5"); //散列算法
        hashedCredentialsMatcher.setHashIterations(3); //散列的次数
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true); //默认是true:Hex编码.false:Base64编码
        return hashedCredentialsMatcher;
    }


    /**
     * @description: 设置资源的权限控制
     * @date: 2019-08-05 8:31 AM
     * @return: java.util.Map
     */
    private Map<String, String> getFilterChainDefinitionMap() {
        Map<String, String> filterMap = new LinkedHashMap<>();
        //需身份认证
        filterMap.put("/stuListView", "authc");
        filterMap.put("/teaListView", "authc");
        //无需身份认证:防止验证用户登录信息操作被'filterMap.put("/**", "authc")'拦截
        filterMap.put("/login", "anon");
        //注销过滤器:其具体的注销逻辑代码Shiro已经替我们实现了哟
        filterMap.put("/logout", "logout");
        //角色过滤:需要用户拥有'admin'角色
        filterMap.put("/teaListView", "roles[admin]");
        //权限过滤:除身份认证外,还需要用户拥有对stuListView资源的view权限
        filterMap.put("/stuListView", "perms[stuListView:view]");
        filterMap.put("/teaListView", "perms[teaListView:view]");
        //拦截需要登录(用户认证)方可访问的资源(一般将/**放在最下边,不然会导致所有url都被拦截哟)
        filterMap.put("/**", "authc");
        return filterMap;
    }


    /**
     * @description: 配置ShiroDialect,用于thymeleaf和shiro标签配合使用
     * @date: 2019-08-05 6:37 PM
     * @return: at.pollux.thymeleaf.shiro.dialect.ShiroDialect
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}