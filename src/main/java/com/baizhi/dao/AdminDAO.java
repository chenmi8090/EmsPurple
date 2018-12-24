package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDAO {

    //登陆方法
    public Admin queryAdminByUsernameAndPassword(Admin admin);

    //根据用户名查询用户信息
    public Admin queryAdminByUsername(Admin admin);

    //注册方法
    public void insertAdmin(Admin admin);

}
