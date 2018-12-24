package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;

import java.util.List;
import java.util.Set;

public interface PermissionService {

    // 根据用户名查询对应的用户所扮演角色
    public Set<Permission> findPermissionByRoleId(String username);

}
