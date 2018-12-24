package com.baizhi.service;

import com.baizhi.dao.RoleDAO;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<Role> findRoleByUsername(Admin admin) {
        return roleDAO.queryRoleByUsername(admin.getUsername());
    }
}
