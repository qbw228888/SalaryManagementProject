package com.SalaryManagement.Service.Impl;

import com.SalaryManagement.Dao.ScaleDao;
import com.SalaryManagement.Domain.Scale;
import com.SalaryManagement.Service.ScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScaleServiceImpl implements ScaleService {
    @Autowired
    ScaleDao scaleDao;

    public List<Scale> getScales() {
        List<Scale> scales = scaleDao.getScales();
        return scales;
    }

    public Scale getScale(int id) {
        Scale scale = scaleDao.getScale(id);
        return scale;
    }

    public boolean deleteScale(int id) {
        boolean flag = scaleDao.deleteScales(id);
        return flag;
    }

    public boolean addScale(Scale scale) {
        boolean flag = scaleDao.addScale(scale);
        return flag;
    }

    public boolean updateScale(int newId, double salary, String description) {
        Scale scale = new Scale();
        scale.setId(newId);
        scale.setSalary(salary);
        scale.setDescription(description);
        boolean flag = scaleDao.updateScale(scale);
        return flag;
    }
}
