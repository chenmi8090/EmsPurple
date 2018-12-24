package com.baizhi.entity;

// 权限实体类

public class Permission {

    private String id;
    private String permissionName;
    private String permissionTag;

    public Permission() {
    }

    public Permission(String id, String permissionName, String permissionTag) {
        this.id = id;
        this.permissionName = permissionName;
        this.permissionTag = permissionTag;
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

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }
}
