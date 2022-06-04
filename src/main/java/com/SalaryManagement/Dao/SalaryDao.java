package com.SalaryManagement.Dao;

import com.SalaryManagement.Domain.Salary;

import java.util.List;

public interface SalaryDao {
    /**
     * 查询工资记录
     * @param eid
     * @param salaryTime
     * @param scale
     * @return
     */
    public List<Salary> getSalaries(int eid, String name, String salaryTime, int scale);

    /**
     * 删除工资记录
     * @param eid
     * @return
     */
    public boolean deleteSalary(int eid, String salaryTime);

    /**
     * 得到员工的起薪
     * @param eid
     * @return
     */
    public double getBaseSalary(int eid);

    /**
     * 添加工资记录
     * @param eid
     * @param salaryTime
     * @param baseSalary
     * @param allowance
     * @param deduction
     * @param realSalary
     * @return
     */
    public boolean addSalary(int eid, String salaryTime, double baseSalary, double allowance, double deduction, double realSalary);

    /**
     * 更改工资记录
     * @param eid
     * @param salaryTime
     * @param allowance
     * @param deduction
     * @param realSalary
     * @return
     */
    public boolean updateSalary(int eid, String salaryTime, double allowance, double deduction, double realSalary);
}
