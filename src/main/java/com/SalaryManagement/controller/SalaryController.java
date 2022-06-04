package com.SalaryManagement.controller;

import com.SalaryManagement.Domain.Salary;
import com.SalaryManagement.Service.SalaryService;
import com.mysql.cj.PreparedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @RequestMapping("/showSalaries")
    @ResponseBody
    public List<Salary> showSalaries(HttpServletRequest request){
        String eidStr = request.getParameter("eid");
        String name = request.getParameter("name");
        String salaryTime = request.getParameter("salaryTime");
        String scaleStr = request.getParameter("scale");
        int eid = 0;
        if (eidStr!=null && eidStr.length()>0 && !eidStr.equals("null")){
            eid = Integer.parseInt(eidStr);
        }
        int scale = 0;
        if (scaleStr!=null && scaleStr.length()>0 && !scaleStr.equals("null")){
            scale = Integer.parseInt(scaleStr);
        }
        List<Salary> salaries = salaryService.getSalaries(eid, name, salaryTime, scale);
        return salaries;
    }

    @RequestMapping("/salary/delete")
    @ResponseBody
    public boolean deleteSalary(int eid, String salaryTime){
        boolean flag = salaryService.deleteSalary(eid,salaryTime);
        return flag;
    }

    @RequestMapping("/salary/add")
    public String toAddSalary(){
        return "salary_add";
    }

    @RequestMapping("/salary/getBaseSalary")
    @ResponseBody
    public double getBaseSalary(int eid){
        double baseSalary = salaryService.getBaseSalary(eid);
        return baseSalary;
    }

    @RequestMapping("/salary/addSalary")
    @ResponseBody
    public boolean addSalary(HttpServletRequest request){
        int eid = Integer.parseInt(request.getParameter("id"));
        String salaryTime = request.getParameter("salaryTime");
        double baseSalary = Double.parseDouble(request.getParameter("baseSalary"));
        double allowance = Double.parseDouble(request.getParameter("allowance"));
        double deduction = Double.parseDouble(request.getParameter("deduction"));
        double realSalary = Double.parseDouble(request.getParameter("realSalary"));
        boolean flag = salaryService.addSalary(eid, salaryTime, baseSalary, allowance, deduction, realSalary);
        return flag;

    }

    @RequestMapping("/salary/update")
    public String toUpadateSalary(){
        return "salary_update";
    }

    @RequestMapping("/salary/updateSalary")
    @ResponseBody
    public boolean updateSalary(HttpServletRequest request){
        int eid = Integer.parseInt(request.getParameter("id"));
        String salaryTime = request.getParameter("salaryTime");
        double allowance = Double.parseDouble(request.getParameter("allowance"));
        double deduction = Double.parseDouble(request.getParameter("deduction"));
        double realSalary = Double.parseDouble(request.getParameter("realSalary"));
        boolean flag = salaryService.updateSalary(eid, salaryTime, allowance, deduction, realSalary);
        return flag;
    }
}
