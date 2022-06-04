package com.SalaryManagement.Service;

import com.SalaryManagement.Domain.Scale;

import java.util.List;

public interface ScaleService {

    /**
     * 查询所有工资等级
     * @return
     */
    public List<Scale> getScales();

    /**
     * 查询一个工资等级
     * @param id
     * @return
     */
    public Scale getScale(int id);

    /**
     * 删除工资等级
     * @param id
     * @return
     */
    public boolean deleteScale(int id);

    /**
     * 添加工资等级
     * @param scale
     * @return
     */
    public boolean addScale(Scale scale);

    /**
     * 修改工资信息
     * @param newId
     * @param salary
     * @param description
     * @return
     */
    public boolean updateScale(int newId, double salary, String description);
}
