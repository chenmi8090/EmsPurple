package com.baizhi.service;

import com.baizhi.dao.PermissionDAO;
import com.baizhi.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<Permission> findPermissionByRoleId(String username) {
        return permissionDAO.queryPermissionByRoleId(username);
    }
}
