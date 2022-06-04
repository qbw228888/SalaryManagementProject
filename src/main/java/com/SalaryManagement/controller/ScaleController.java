package com.SalaryManagement.controller;

import com.SalaryManagement.Domain.Scale;
import com.SalaryManagement.Service.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ScaleController {
    @Autowired
    ScaleService scaleService;


    @RequestMapping("/showScales")
    @ResponseBody
    public List<Scale> getScales(){
        List<Scale> scales = scaleService.getScales();
        return scales;
    }

    @RequestMapping("/getScale")
    @ResponseBody
    public Scale getScale(int id){
        Scale scale = scaleService.getScale(id);
        return scale;
    }

    @RequestMapping("/scale/delete")
    @ResponseBody
    public boolean deleteScale(int id){
        boolean flag = scaleService.deleteScale(id);
        return flag;
    }

    @RequestMapping("/scale/add")
    public String toAddScale(){
        return "scale_add";
    }

    @RequestMapping("/scale/addScale")
    @ResponseBody
    public boolean addScale(Scale scale){
        boolean flag = scaleService.addScale(scale);
        return flag;
    }

    @RequestMapping("/scale/update")
    public String toUpdateScale(){
        return "scale_update";
    }

    @RequestMapping("/scale/updateScale")
    @ResponseBody
    public boolean updateScale(HttpServletRequest request){
        int newId = Integer.parseInt(request.getParameter("newId"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        String description = request.getParameter("description");
        boolean flag = scaleService.updateScale(newId, salary, description);
        return flag;
    }
}
