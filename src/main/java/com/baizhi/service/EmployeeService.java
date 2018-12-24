package com.baizhi.service;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //查询所有员工方法
    public List<Employee> findAllEmployees(Integer page);

    //查询所有员工数量
    public Integer findCounts();

    //根据ID查询对应员工
    public Employee findEmployeeById(Employee employee);

    //添加员工
    public void addEmployee(Employee employee);

    //修改员工
    public void modifyEmployee(Employee employee);

    //删除员工
    public void removeEmployee(String id);

}
