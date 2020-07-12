package com.rjf.shiro;

/*
 *
 *   Rene
 *   2020/7/12 14:29
 */

import java.util.List;

public class Role {

    private String id;
    private String roleName;

    private List<Permission> permissions;

    public Role() {
    }

    public Role(String id, String roleName, List<Permission> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
