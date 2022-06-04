package com.SalaryManagement.Domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private int id;//编号
    private String name;//姓名
    private String sex;//性别
    private String birth;//出生日期
    private String entry;//入职日期
    private int age;//年龄
    private String department;//部门
    private String position;//职位
    private int scale;//工资等级
    private String email;//邮箱
    private String phone;//电话号码

    //无参构造器
    public Employee() { }

    //有参构造器
    public Employee(int id, String name, String sex, String birth, String entry, int age, String department, String position, int scale, String email, String phone) throws ParseException {
        DateFormat dateFormat = DateFormat.getDateInstance();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.entry = entry;
        this.age = age;
        this.department = department;
        this.position = position;
        this.scale = scale;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth){
        this.birth = birth;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry){
        this.entry = entry;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", entry=" + entry +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", scale=" + scale +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
