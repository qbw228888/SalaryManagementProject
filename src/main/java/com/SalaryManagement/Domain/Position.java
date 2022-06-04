package com.SalaryManagement.Domain;

public class Position {
    private int id;//职位编号
    private String name;//职位名称
    private String description;//职位描述

    //无参构造器
    public Position() {
    }

    //有参构造器
    public Position(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
