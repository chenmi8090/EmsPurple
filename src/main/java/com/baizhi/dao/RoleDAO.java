package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface RoleDAO {

    //根据用户名查询对应的 用户角色
    public Set<Role> queryRoleByUsername(@Param("username") String username);

}
