package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {

    //管理员登陆方法
    public Admin adminLogin(Admin admin);

    //根据管理员登录名获取管理员对象
    public Admin queryAdminByUsername(Admin admin);

    //注册管理员方法
    public void addAdmin(Admin admin);

}
