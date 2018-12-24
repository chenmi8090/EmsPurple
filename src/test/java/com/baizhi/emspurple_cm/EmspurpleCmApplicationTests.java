package com.baizhi.emspurple_cm;

import com.baizhi.entity.Employee;
import com.baizhi.entity.Permission;
import com.baizhi.service.EmployeeService;
import com.baizhi.service.PermissionService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.support.DelegatingSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmspurpleCmApplicationTests {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PermissionService permissionService;

    @Test
    public void contextLoads() {

        /*List<Employee> allEmployees = employeeService.findAllEmployees(0);
        for (Employee allEmployee : allEmployees) {
            System.out.println(allEmployee);
        }*/
    }

    @Test
    public void UUID() {

        System.out.println(UUID.randomUUID().toString());

    }

    @Test
    public void Md5Test(){
        Md5Hash md5Hash = new Md5Hash("123456","47aa1715-89c0-48b4-99c7-f85406af357a");
        System.out.println(md5Hash);
    }

    @Test
    public void select(){
        /*Set<Permission> permissionByRoleId = permissionService.findPermissionByRoleId("aaa");
        for (Permission permission : permissionByRoleId) {
            System.out.println(permission);
        }*/
        System.out.println(DelegatingSubject.class.getName() + ".RUN_AS_PRINCIPALS_SESSION_KEY");
    }

    @Test
    public void selectOne(){
        Set<Permission> permissionByRoleId = permissionService.findPermissionByRoleId("aaa");
        for (Permission permission : permissionByRoleId) {
            System.out.println(permission);
        }
    }

}

