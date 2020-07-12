package com.rjf.shiro;

/*
 *
 *   Rene
 *   2020/7/12 14:31
 */

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginService {

    public User getUserByName(String name){
        return getMapByName(name);
    }

    private User getMapByName(String userName){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permission Permission1 = new Permission("1","query");
        Permission Permission2 = new Permission("2","add");
        List<Permission> PermissionList = new ArrayList<>();
        PermissionList.add(Permission1);
        PermissionList.add(Permission2);
        Role role = new Role("1","admin",PermissionList);
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        User user = new User("1","wsl","123456",roleList);
        Map<String ,User> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Permission Permission3 = new Permission("3","query");
        List<Permission> PermissionList1 = new ArrayList<>();
        PermissionList1.add(Permission3);
        Role role1 = new Role("2","user",PermissionList1);
        List<Role> roleList1 = new ArrayList<>();
        roleList1.add(role1);
        User user1 = new User("2","zhangsan","123456",roleList1);
        map.put(user1.getUserName(), user1);
        return map.get(userName);
    }
}
