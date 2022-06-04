package com.SalaryManagement.controller;

import com.SalaryManagement.Domain.User;
import com.SalaryManagement.Service.Impl.UserServiceImpl;
import com.SalaryManagement.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    //处理登录请求
    @RequestMapping(value = "/login/application" ,method = RequestMethod.POST)
    @ResponseBody
    public boolean login(User user , HttpSession session) throws IOException {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username+","+password);
        boolean flag = userService.login(username, password);
        if (flag){
            session.setAttribute("user",user);
            return true;
        } else {
            return false;
        }
    }

    //得到用户
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        System.out.println(user);
        return user;
    }

    //处理注册请求
    @RequestMapping(value = "/register/application")
    @ResponseBody
    public boolean register(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username+"  "+password);
        boolean flag = userService.register(username, password);
        if (flag){
            return true;
        } else {
            return false;
        }
    }
}
