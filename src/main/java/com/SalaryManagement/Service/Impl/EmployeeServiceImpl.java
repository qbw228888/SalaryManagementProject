package com.SalaryManagement.Service.Impl;

import com.SalaryManagement.Dao.EmployeeDao;
import com.SalaryManagement.Dao.Impl.EmployeeDaoImpl;
import com.SalaryManagement.Domain.Employee;
import com.SalaryManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    public List<Employee> getEmployees(int id, String name, String department, String position, int scale) {
        if (name != null){
            if (name.equals("null")){
                name = null;
            }
        }
        if (department != null) {
            if (department.equals("null")) {
                department = null;
            }
        }
        if (position != null) {
            if (position.equals("null")) {
                position = null;
            }
        }
        List<Employee> employees = employeeDao.getEmployees(id, name, department, position, scale);
        return employees;
    }

    public boolean addEmployee(String name, String sex, String entry, String birth, int age,
                               String email, String phone, String department, String position, int scale){
        int count = employeeDao.countEmployees();
        int id = count + 1;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setSex(sex);
        employee.setEntry(entry);
        employee.setBirth(birth);
        employee.setAge(age);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setScale(scale);
        boolean flag = employeeDao.addEmployee(employee);
        return flag;
    }


    //@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean deleteEmployee(int id) {
        boolean flag1 = employeeDao.deleteEmployee(id);
        boolean flag2 = true;
        if (flag1 && flag2){
            return true;
        } else {
            return false;
        }
    }


    public boolean updateEmployee(int id, String name, String sex, String entry, String birth, int age, String email, String phone, String department, String position, int scale) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setSex(sex);
        employee.setEntry(entry);
        employee.setBirth(birth);
        employee.setAge(age);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setScale(scale);
        boolean flag = employeeDao.updateEmployee(employee);
        return flag;
    }
}
