package com.baizhi.dao;

import com.baizhi.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeDAO {

    //查询所有员工
    public List<Employee> queryAll(@Param("pageStart")Integer pageStart,@Param("pageEnd")Integer pageEnd);

    //查询所有员工数量
    public Integer queryCounts();

    //根据ID查询员工
    public Employee queryEmployeeById(@Param("id")String id);

    //添加员工
    public void insertEmployee(Employee employee);

    //修改员工
    public void updateEmployee(Employee employee);

    //删除员工
    public void deleteEmployee(@Param("id")String id);

}
