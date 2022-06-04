package com.SalaryManagement.Dao;

import com.SalaryManagement.Domain.Scale;

import java.util.List;

public interface ScaleDao {

    /**
     * 获取所有工资等级
     * @return
     */
    public List<Scale> getScales();

    /**
     * 得到一个工资等级
     * @return
     */
    public Scale getScale(int id);

    /**
     * 删除工资等级
     * @return
     */
    public boolean deleteScales(int id);

    /**
     * 添加工资等级
     * @param scale
     * @return
     */
    public boolean addScale(Scale scale);

    /**
     * 修改员工信息
     * @param scale
     * @return
     */
    public boolean updateScale(Scale scale);
}
