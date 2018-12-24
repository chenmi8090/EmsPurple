package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Role;
import org.apache.catalina.User;

import java.util.Set;

public interface RoleService {

    // 根据用户名查询对应的用户所扮演角色
    public Set<Role> findRoleByUsername(Admin admin);

}
