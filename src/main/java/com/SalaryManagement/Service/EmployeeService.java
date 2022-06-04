package com.SalaryManagement.Service;

import com.SalaryManagement.Domain.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 获取全部员工信息
     * @return
     */
    public List<Employee> getEmployees(int id, String name, String department, String position, int scale);

    /**
     * 封装员工对象，并调用DAO添加到数据库
     * @param name
     * @param sex
     * @param entry
     * @param birth
     * @param age
     * @param email
     * @param phone
     * @param department
     * @param position
     * @param scale
     * @return
     */
    public boolean addEmployee(String name, String sex, String entry, String birth, int age,
                               String email, String phone, String department, String position, int scale);

    /**
     * 删除员工以及相关的工资记录
     * @param id
     * @return
     */
    public boolean deleteEmployee(int id);

    /**
     * 更新员工表的记录
     * @param id
     * @param name
     * @param sex
     * @param entry
     * @param birth
     * @param age
     * @param email
     * @param phone
     * @param department
     * @param position
     * @param scale
     * @return
     */
    public boolean updateEmployee(int id, String name, String sex, String entry, String birth, int age,
                                  String email, String phone, String department, String position, int scale);
}
