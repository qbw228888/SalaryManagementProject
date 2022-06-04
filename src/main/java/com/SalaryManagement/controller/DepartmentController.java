package com.SalaryManagement.controller;

import com.SalaryManagement.Domain.Department;
import com.SalaryManagement.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/showDepartments")
    @ResponseBody
    public List<Department> showDepartments(){
        List<Department> departments = departmentService.getDepartments();
        return departments;
    }

    @RequestMapping("/getDepartment")
    @ResponseBody
    public Department getDepartment(int id){
        Department department = departmentService.getDepartment(id);
        return department;
    }

    @RequestMapping("/department/add")
    public String toAddDepartment(){
        return "department_add";
    }

    @RequestMapping("/department/addDepartment")
    @ResponseBody
    public boolean addDepartment(HttpServletRequest request){
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String countStr = request.getParameter("count");
        int id = Integer.parseInt(idStr);
        int count = Integer.parseInt(countStr);
        boolean flag = departmentService.addDepartment(id, name, count);
        return flag;
    }

    @RequestMapping("/department/delete")
    @ResponseBody
    public boolean deleteDepartment(int id){
        boolean flag = departmentService.deleteDepartment(id);
        return flag;
    }

    @RequestMapping("/department/update")
    public String toUpdateDepartment(){
        return "department_update";
    }

    @RequestMapping("/department/updateDepartment")
    @ResponseBody
    public boolean updateDepartment(HttpServletRequest request){
        String oldIdStr = request.getParameter("oldId");
        String newIdStr = request.getParameter("newId");
        String name = request.getParameter("name");
        String countStr = request.getParameter("count");
        int oldId = 0;
        if (oldIdStr != null && !oldIdStr.equals("null")){
            oldId = Integer.parseInt(oldIdStr);
        }
        int newId = 0;
        if (newIdStr != null && !newIdStr.equals("null")){
            newId = Integer.parseInt(newIdStr);
        }
        int count = 0;
        if (countStr != null && !countStr.equals("null")){
            count = Integer.parseInt(countStr);
        }
        boolean flag = departmentService.updateDepartment(oldId, newId, name, count);
        return flag;
    }
}
