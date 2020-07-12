package com.rjf.shiro;

/*
 *
 *   Rene
 *   2020/7/12 14:30
 */

public class Permission {

    private String id;
    private String permissionName;

    public Permission() {
    }

    public Permission(String id, String permissionName) {
        this.id = id;
        this.permissionName = permissionName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
