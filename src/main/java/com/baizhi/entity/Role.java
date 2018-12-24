package com.baizhi.entity;

// 角色实体类

public class Role {

    private String id;
    private String roleName;
    private String roleTag;

    public Role() {
    }

    public Role(String id, String roleName, String roleTag) {
        this.id = id;
        this.roleName = roleName;
        this.roleTag = roleTag;
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

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }
}
