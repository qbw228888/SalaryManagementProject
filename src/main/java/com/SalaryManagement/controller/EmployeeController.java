package com.SalaryManagement.controller;

import com.SalaryManagement.Domain.Employee;
import com.SalaryManagement.Service.EmployeeService;
import com.SalaryManagement.Service.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping(value = "/showEmployees")
    @ResponseBody
    public List<Employee> showEmployees(HttpServletRequest request){
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        String scaleStr = request.getParameter("scale");
        int id = 0;//给id赋默认值，0
        if (idStr != null && idStr.length()>0 && !idStr.equals("null")){
            id = Integer.parseInt(idStr);
        }
        int scale = 0;
        if (scaleStr != null && scaleStr.length()>0 && !scaleStr.equals("null")){
            scale = Integer.parseInt(scaleStr);
        }
        List<Employee> employees = employeeService.getEmployees(id, name, department, position, scale);
        return employees;
    }

    @RequestMapping("/employee/add")
    public String toAddEmployee(){
        return "employee_add";
    }

    @RequestMapping("/employee/addEmployee")
    @ResponseBody
    public boolean addEmployee(HttpServletRequest request){
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String entry = request.getParameter("entry");
        String birth = request.getParameter("birth");
        String ageStr = request.getParameter("age");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        String scaleStr = request.getParameter("scale");
        int age = 0;
        if (ageStr != null && !ageStr.equals("null")){
            age = Integer.parseInt(ageStr);
        }
        int scale = 0;
        if (scaleStr != null && !scaleStr.equals("null")){
            scale = Integer.parseInt(scaleStr);
        }
        boolean flag = employeeService.addEmployee(name, sex, entry, birth, age, email, phone, department, position, scale);
        return flag;
    }

    @RequestMapping("/employee/delete")
    @ResponseBody
    public boolean deleteEmployee(int id){
        boolean flag = employeeService.deleteEmployee(id);
        return flag;
    }

    @RequestMapping("/employee/update")
    public String toUpdateEmployee(){
        return "employee_update";
    }

    @RequestMapping("/employee/updateEmployee")
    @ResponseBody
    public boolean updateEmployee(HttpServletRequest request){
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String entry = request.getParameter("entry");
        String birth = request.getParameter("birth");
        String ageStr = request.getParameter("age");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        String scaleStr = request.getParameter("scale");
        int id = 0;
        if (idStr != null && !idStr.equals("null")){
            id = Integer.parseInt(idStr);
        }
        int age = 0;
        if (ageStr != null && !ageStr.equals("null")){
            age = Integer.parseInt(ageStr);
        }
        int scale = 0;
        if (scaleStr != null && !scaleStr.equals("null")){
            scale = Integer.parseInt(scaleStr);
        }
        boolean flag = employeeService.updateEmployee(id, name, sex, entry, birth, age, email, phone, department, position, scale);
        return flag;
    }

}
