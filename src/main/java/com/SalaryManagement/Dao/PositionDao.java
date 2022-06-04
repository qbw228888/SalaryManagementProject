package com.SalaryManagement.Dao;

import com.SalaryManagement.Domain.Position;

import java.util.List;

public interface PositionDao {
    /**
     * 查询所有职位
     * @return
     */
    public List<Position> getPositionList();

    /**
     * 获取单个职位
     * @param id
     * @return
     */
    public Position getPosition(int id);

    /**
     * 添加职位信息
     * @return
     */
    public boolean addPosition(Position position);

    /**
     * 删除职位信息
     * @param id
     * @return
     */
    public boolean deletePosition(int id);

    /**
     * 修改职位信息
     * @param oldId
     * @param position
     * @return
     */
    public boolean updatePosition(int oldId, Position position);
}
