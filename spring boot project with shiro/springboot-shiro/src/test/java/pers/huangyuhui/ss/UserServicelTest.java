package pers.huangyuhui.ss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.huangyuhui.ss.bean.Permission;
import pers.huangyuhui.ss.bean.Role;
import pers.huangyuhui.ss.bean.User;
import pers.huangyuhui.ss.service.UserService;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServicelTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindByName() {
        User info = userService.findByName("tea");
        Set<Role> roleSet = info.getRoles();
        System.err.println("[info.getRole]------>" + info.getRoles().toString());
        for (Role role : roleSet) {
            Set<Permission> permissionSet = role.getPermissions();
            System.err.println("[role.getPermissions()]------>" + role.getPermissions().toString());
            for (Permission permission : permissionSet) {
                System.err.println("[permission]------>" + permission.getName());
            }
            System.err.println("[role]------>" + role.getName());
        }
    }
}