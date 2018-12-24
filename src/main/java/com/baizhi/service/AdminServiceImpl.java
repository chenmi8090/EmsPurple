package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Admin adminLogin(Admin admin) {
        Admin adminLogin = adminDAO.queryAdminByUsernameAndPassword(admin);

        return adminLogin;
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Admin queryAdminByUsername(Admin admin) {

        Admin adminByUsername = adminDAO.queryAdminByUsername(admin);

        return adminByUsername;
    }

    @Override
    public void addAdmin(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        admin.setSalt(UUID.randomUUID().toString());
        admin.setStatus("正常");
        Md5Hash md5Hash = new Md5Hash(admin.getPassword(),admin.getSalt());
        admin.setPassword(String.valueOf(md5Hash));
        adminDAO.insertAdmin(admin);
    }
}
