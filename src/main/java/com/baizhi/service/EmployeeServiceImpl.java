package com.baizhi.service;

import com.baizhi.dao.EmployeeDAO;
import com.baizhi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Value(value="${rows}")
    private String rows;

    @Override
    public List<Employee> findAllEmployees(Integer page) {
        Integer row = Integer.valueOf(rows);
        Integer pageStart = (page-1)*row;
        Integer pageEnd = page*row;
        return employeeDAO.queryAll(pageStart,pageEnd);
    }

    @Override
    public Integer findCounts() {
        Integer row = Integer.valueOf(rows);
        Integer counts = employeeDAO.queryCounts();
        //计算出最大页数
        Integer maxPage;
        if(counts%row==0){
            maxPage=counts/row;
        }else{
            maxPage=counts/row+1;
        }
        return maxPage;
    }

    @Override
    public Employee findEmployeeById(Employee employee) {
        return employeeDAO.queryEmployeeById(employee.getId());
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setStatus("正常");
        employeeDAO.insertEmployee(employee);
    }

    @Override
    public void modifyEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void removeEmployee(String id) {
        employeeDAO.deleteEmployee(id);
    }
}
