package com.baizhi.dao;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface PermissionDAO {

    //根据用户名查询对应的 用户角色
    public Set<Permission> queryPermissionByRoleId(@Param("username") String username);

}
