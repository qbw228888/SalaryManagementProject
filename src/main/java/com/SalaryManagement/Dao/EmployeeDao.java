package com.SalaryManagement.Dao;

import com.SalaryManagement.Domain.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * 查询所有员工的信息
     * @return
     */
    public List<Employee> getEmployees(int id, String name, String department, String position, int scale);

    /**
     * 查询员工数量
     * @return
     */
    public int countEmployees();

    /**
     * 添加员工到数据库
     * @param employee
     * @return
     */
    public boolean addEmployee(Employee employee);

    /**
     * 删除员工数据
     * @param id
     * @return
     */
    public boolean deleteEmployee(int id);

    /**
     * 更新员工记录
     * @param employee
     * @return
     */
    public boolean updateEmployee(Employee employee);
}
