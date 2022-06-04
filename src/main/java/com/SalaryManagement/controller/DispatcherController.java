package com.SalaryManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DispatcherController {
    //访问首页
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    //访问导航页面
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    //访问登录页
    @RequestMapping("/login")
    public String logIn(){
        return "login";
    }

    //访问注册页面
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    //访问员工信息页
    @RequestMapping("/employee")
    public String employee(){
        return "employee";
    }

    //访问工资信息页
    @RequestMapping("/salary")
    public String salary(){
        return "salary";
    }

    //访问部门信息页
    @RequestMapping("/department")
    public String department(){
        return "department";
    }

    //访问职位信息页
    @RequestMapping("/position")
    public String position() {
        return "position";
    }

    //访问工资等级页
    @RequestMapping("/scale")
    public String scale(){
        return "scale";
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }
}
