package com.SalaryManagement.Service.Impl;

import com.SalaryManagement.Dao.DepartmentDao;
import com.SalaryManagement.Dao.Impl.DepartmentDaoImpl;
import com.SalaryManagement.Domain.Department;
import com.SalaryManagement.Service.DepartmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    public List<Department> getDepartments() {
        List<Department> departments = departmentDao.getDepartments();
        return departments;
    }

    public Department getDepartment(int id) {
        Department department = departmentDao.getDepartment(id);
        return department;
    }

    public boolean addDepartment(int id, String name, int count) {
        Department department = new Department();
        department.setId(id);
        department.setName(name);
        department.setCount(count);
        boolean flag = departmentDao.addDepartment(department);
        return flag;
    }

    public boolean deleteDepartment(int id) {
        boolean flag = departmentDao.deleteDepartment(id);
        return flag;
    }

    public boolean updateDepartment(int oldId, int newId, String name, int count) {
        Department department = new Department();
        department.setId(newId);
        department.setName(name);
        department.setCount(count);
        boolean flag = departmentDao.updateDepartment(oldId, department);
        return flag;
    }

//    @Test
//    public void test(){
//        DepartmentService departmentService = new DepartmentServiceImpl();
//        Department department = departmentService.getDepartment(1);
//        System.out.println(department);
//    }
}
