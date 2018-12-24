package com.baizhi.util;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.service.AdminService;
import com.baizhi.service.PermissionService;
import com.baizhi.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

public class RealmConfig extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    // 获取日志采集器
    private static final Logger log = LoggerFactory.getLogger(RealmConfig.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println(1);

        // 获取用户的用户名
        String username = (String)principalCollection.getPrimaryPrincipal();
        // 获取处理授权信息的简单授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取用户的角色信息
        Set<Role> roles = roleService.findRoleByUsername(new Admin(username));
        // 将用户的角色信息放入简单授权信息对象中
        if(roles != null && roles.size() != 1){
            roles.forEach(role -> info.addRole(role.getRoleTag()));
        }
        // 根据用户账号获取用户角色的权限信息
        Set<Permission> permissions = permissionService.findPermissionByRoleId(username);
        //利用"入"表达式将得到的权限信息放入简单授权信息对象中
        if(permissions != null && permissions.size() != 1){
            permissions.forEach(permission -> info.addStringPermission(permission.getPermissionTag()));
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        Admin admin = adminService.queryAdminByUsername(new Admin(username));
        if(admin != null){
            return new SimpleAccount(admin.getUsername(),admin.getPassword(), ByteSource.Util.bytes(admin.getSalt()), UUID.randomUUID().toString());
        }
        return null;
    }
}
