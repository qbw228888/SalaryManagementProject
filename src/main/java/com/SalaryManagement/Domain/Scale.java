package com.SalaryManagement.Domain;

public class Scale {
    private int id;//等级编号
    private double salary;//工资钱数
    private String description;//描述

    public Scale() {
    }

    public Scale(int id, double salary, String description) {
        this.id = id;
        this.salary = salary;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Scale{" +
                "id=" + id +
                ", salary=" + salary +
                ", description='" + description + '\'' +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
