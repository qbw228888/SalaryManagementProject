package com.SalaryManagement.Service.Impl;

import com.SalaryManagement.Dao.PositionDao;
import com.SalaryManagement.Domain.Position;
import com.SalaryManagement.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionDao positionDao;

    public List<Position> getPositionList() {
        List<Position> positionList = positionDao.getPositionList();
        return positionList;
    }

    public Position getPosition(int id) {
        Position position = positionDao.getPosition(id);
        return position;
    }

    public boolean addPosition(int id, String name, String description) {
        Position position = new Position();
        position.setId(id);
        position.setName(name);
        position.setDescription(description);
        boolean flag = positionDao.addPosition(position);
        return flag;
    }

    public boolean deletePosition(int id) {
        boolean flag = positionDao.deletePosition(id);
        return flag;
    }

    public boolean updatePosition(int oldId, int newId, String name, String description) {
        Position position = new Position();
        position.setId(newId);
        position.setName(name);
        position.setDescription(description);
        boolean flag = positionDao.updatePosition(oldId, position);
        return flag;
    }
}
