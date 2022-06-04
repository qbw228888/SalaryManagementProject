package com.SalaryManagement.Service;

import com.SalaryManagement.Domain.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * 得到部门信息
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
     * 添加部门
     * @return
     */
    public boolean addDepartment(int id, String name, int count);

    /**
     * 删除部门
     * @param id
     * @return
     */
    public boolean deleteDepartment(int id);

    /**
     * 更改部门
     * @param name
     * @param count
     * @return
     */
    public boolean updateDepartment(int oldId, int newId, String name, int count);
}
