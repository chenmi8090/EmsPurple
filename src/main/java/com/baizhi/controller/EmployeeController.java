package com.baizhi.controller;

import com.baizhi.entity.Employee;
import com.baizhi.entity.Result;
import com.baizhi.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //对应 该类生成日志文件对象
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/findAllEmployees")
    public String findAllEmployees(Model model,Integer page){
        if(page==null || page==0){
            page=1;
        }
        List<Employee> allEmployees = employeeService.findAllEmployees(page);
        Integer maxPage = employeeService.findCounts();
        model.addAttribute("employees",allEmployees);
        model.addAttribute("page",page);
        model.addAttribute("maxPage",maxPage);
        return "forward:/views/emplist.jsp";
    }

    @RequestMapping("/findEmployeeById")
    public String findEmployeeById(Employee employee,Model model){
        Employee employeeById = employeeService.findEmployeeById(employee);
        model.addAttribute("employeeById",employeeById);
        return "forward:/views/updateEmp.jsp";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee){
        Result result = new Result();
        employee.setId(UUID.randomUUID().toString());
        try{
            employeeService.addEmployee(employee);
            result.setSuccess(true);
            result.setMessage(null);
            return "redirect:/employee/findAllEmployees";
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("添加员工失败！");
            return "redirect:/views/addEmp.jsp";
        }
    }

    @RequestMapping("/modifyEmployee")
    public String modifyEmployee(Employee employee){
        Result result = new Result();
        try{
            employeeService.modifyEmployee(employee);
            result.setSuccess(true);
            result.setMessage("√");
            return "redirect:/employee/findAllEmployees";
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("修改员工失败！");
            return "forward:/views/updateEmp.jsp";
        }

    }

    @RequestMapping("/removeEmployee")
    public String removeEmployee(Employee employee){
        Result result = new Result();
        try{
            employeeService.removeEmployee(employee.getId());
            result.setSuccess(true);
            result.setMessage(null);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除员工失败！");
        }
        return "redirect:/employee/findAllEmployees";
    }
}
