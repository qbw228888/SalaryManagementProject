package com.SalaryManagement.Domain;

import java.util.Date;

public class Salary {
    private int eid;//员工编号
    private String name;//员工姓名
    private String salaryTime;//工资发放时间
    private int scale;
    private double baseSalary;//基础工资
    private double allowance;//津贴
    private double deduction;//扣费
    private double realSalary;//实发工资

    public Salary() {
    }

    public Salary(int eid, String name, String salaryTime, int scale, double baseSalary, double allowance, double deduction, double realSalary) {
        this.eid = eid;
        this.name = name;
        this.salaryTime = salaryTime;
        this.scale = scale;
        this.baseSalary = baseSalary;
        this.allowance = allowance;
        this.deduction = deduction;
        this.realSalary = realSalary;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalaryTime() {
        return salaryTime;
    }

    public void setSalaryTime(String salaryTime) {
        this.salaryTime = salaryTime;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getRealSalary() {
        return realSalary;
    }

    public void setRealSalary(double realSalary) {
        this.realSalary = realSalary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", salaryTime='" + salaryTime + '\'' +
                ", scale=" + scale +
                ", baseSalary=" + baseSalary +
                ", allowance=" + allowance +
                ", deduction=" + deduction +
                ", realSalary=" + realSalary +
                '}';
    }
}
