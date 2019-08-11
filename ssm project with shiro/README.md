---
title: 一个简单的SSM整合Shiro的权限管理案例
date: 2019-08-11 07:43:50
tags: [SSM,Shiro]
---

## 学习笔记 : 一个简单的SSM整合Shiro的权限管理案例
*前些日子写了[一个简单的SpringBoot整合Shiro的权限管理案例](https://github.com/YUbuntu0109/Shiro-learning/tree/master/spring%20boot%20project%20with%20shiro),然后又进阶地学习了SSM整合Shiro的基本知识,继而今天总结一下 : 写一个基本的SSM整合Shiro的权限管理案例(该案例与上述案例思路相同)~*


### 数据库设计
*数据库ER图如下所示 :*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/database/shiro-learning.png)

*数据表中用户及其分配的权限信息如下所示 :*

| 账户  | 密码(MD5加密前) |  角色   |                                   权限                                   |
| :---: | :-------------: | :-----: | :----------------------------------------------------------------------: |
| admin |      demo       |  admin  |                                    *                                     |
|  tea  |      demo       | teacher | teaListView:view , stuListView:view , stuListView:add , stuListView:edit |
|  stu  |      demo       | student |                             stuListView:view                             |


### 案例截屏解析
*用户登录页面,访问资源前必须先进行用户身份认证,详情参考资源拦截器中的配置信息哟*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/screenshots/ssm-shiro-%E7%94%A8%E6%88%B7%E7%99%BB%E5%BD%95%E9%A1%B5%E9%9D%A2.PNG)

*若要访问教师 / 学生信息管理页面,需要用户拥有`teaListView:view / stuListView:view`权限*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/screenshots/ssm-shiro-%E7%94%A8%E6%88%B7%E4%B8%BB%E9%A1%B5.PNG)

*管理员( admin )拥有访问资源的所有权限( * ),所以可以操控学生信息页面中的任何操作*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/screenshots/ssm-shiro-%5Badmin%5D-%E5%AD%A6%E7%94%9F%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2.PNG)

*管理员( admin )拥有访问资源的所有权限( * ),所以可以操控教师信息页面中的任何操作*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/screenshots/ssm-shiro-%5Badmin%5D-%E6%95%99%E5%B8%88%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2.PNG)

*教师( tea )拥有学生页面面的`stuListView:view , stuListView:add , stuListView:edit`权限,所以删除信息操作为不可见*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/screenshots/ssm-shiro-%5Btea%5D-%E5%AD%A6%E7%94%9F%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2.PNG)

*教师( tea )仅拥有教师信息管理页面的`teaListView:view`权限,所以增,删,改,操作为不可见状态*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/screenshots/ssm-shiro-%5Btea%5D-%E6%95%99%E5%B8%88%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2.PNG)

*学生( stu )仅拥有学生信息管理页面的`stuListView:view`权限,所以增,删,改,操作为不可见状态*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/screenshots/ssm-shiro-%5Bstu%5D-%E5%AD%A6%E7%94%9F%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2.PNG)

*学生( stu )没有访问教师信息管理页面的权限,所以被资源拦截器所拦截继而进入指定的'unauthorized.html'页面面*
![](https://raw.githubusercontent.com/YUbuntu0109/Shiro-learning/master/ssm%20project%20with%20shiro/screenshots/ssm-shiro-%5Bstu%5D-%E6%95%99%E5%B8%88%E4%BF%A1%E6%81%AF%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2.PNG)
