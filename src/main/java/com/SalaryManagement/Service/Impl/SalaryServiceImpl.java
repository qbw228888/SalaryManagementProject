package com.SalaryManagement.Service.Impl;

import com.SalaryManagement.Dao.SalaryDao;
import com.SalaryManagement.Domain.Salary;
import com.SalaryManagement.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalaryDao salaryDao;

    public List<Salary> getSalaries(int eid, String name, String salaryTime, int scale) {
        if (name.equals("null")){
            name = null;
        }
        if (salaryTime.equals("null")){
            salaryTime = null;
        }
        List<Salary> salaries = salaryDao.getSalaries(eid, name, salaryTime, scale);
        return salaries;
    }

    public boolean deleteSalary(int eid, String salaryTime) {
        boolean flag = salaryDao.deleteSalary(eid, salaryTime);
        return flag;
    }

    public double getBaseSalary(int eid) {
        double baseSalary = salaryDao.getBaseSalary(eid);
        return baseSalary;
    }

    public boolean addSalary(int eid, String salaryTime, double baseSalary, double allowance, double deduction, double realSalary) {
        boolean flag = salaryDao.addSalary(eid, salaryTime, baseSalary, allowance, deduction, realSalary);
        return flag;
    }

    public boolean updateSalary(int eid, String salaryTime, double allowance, double deduction, double realSalary) {
        boolean flag = salaryDao.updateSalary(eid, salaryTime, allowance, deduction, realSalary);
        return flag;
    }
}
