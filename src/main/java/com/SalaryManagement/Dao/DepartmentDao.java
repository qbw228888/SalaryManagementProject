package com.SalaryManagement.Dao;

import com.SalaryManagement.Domain.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {

    /**
     * 查询所有部门信息
     * @return
     */
    public List<Department> getDepartments();

    /**
     * 查询一个部门
     * @param id
     * @return
     */
    public Department getDepartment(int id);

    /**
     * 添加部门信息
     * @param department
     * @return
     */
    public boolean addDepartment(Department department);

    /**
     * 删除部门信息
     * @param id
     * @return
     */
    public boolean deleteDepartment(int id);

    /**
     * 更改部门信息
     * @param department
     * @return
     */
    public boolean updateDepartment(int oldId, Department department);
}
