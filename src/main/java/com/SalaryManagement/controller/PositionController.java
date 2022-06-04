package com.SalaryManagement.controller;

import com.SalaryManagement.Domain.Position;
import com.SalaryManagement.Service.PositionService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PositionController {
    @Autowired
    PositionService positionService;

    @RequestMapping("/showPositions")
    @ResponseBody
    public List<Position> getPositionList(){
        List<Position> positionList = positionService.getPositionList();
        return positionList;
    }

    @RequestMapping("/getPosition")
    @ResponseBody
    public Position getPosition(int id){
        Position position = positionService.getPosition(id);
        return position;
    }

    @RequestMapping("/position/add")
    public String toAddPosition(){
        return "position_add";
    }

    @RequestMapping("/position/addPosition")
    @ResponseBody
    public boolean addPosition(HttpServletRequest request){
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int id = 0;
        if (idStr != null && idStr.length()>0 && !idStr.equals("null")){
            id = Integer.parseInt(idStr);
        }
        boolean flag = positionService.addPosition(id, name, description);
        return flag;
    }

    @RequestMapping("/position/delete")
    @ResponseBody
    public boolean deletePosition(int id){
        boolean flag = positionService.deletePosition(id);
        return flag;
    }

    @RequestMapping("/position/update")
    public String toUpdatePosition(){
        return "position_update";
    }

    @RequestMapping("/position/updatePosition")
    @ResponseBody
    public boolean updatePosition(HttpServletRequest request){
        String oldIdStr = request.getParameter("oldId");
        String newIdStr = request.getParameter("newId");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int oldId = 0;
        if (oldIdStr != null && oldIdStr.length()>0 && !oldIdStr.equals("null")){
            oldId = Integer.parseInt(oldIdStr);
        }
        int newId = 0;
        if (newIdStr != null && newIdStr.length()>0 && !newIdStr.equals("null")){
            newId = Integer.parseInt(newIdStr);
        }
        boolean flag = positionService.updatePosition(oldId, newId, name, description);
        return flag;
    }
}
