package com.SalaryManagement.Service;

import com.SalaryManagement.Domain.Position;

import java.util.List;

public interface PositionService {

    /**
     * 得到职位列表
     * @return
     */
    public List<Position> getPositionList();

    /**
     * 获取职位信息
     * @param id
     * @return
     */
    public Position getPosition(int id);

    /**
     * 添加职位信息
     * @param id
     * @param name
     * @param description
     * @return
     */
    public boolean addPosition(int id, String name, String description);

    /**
     * 删除职位信息
     * @param id
     * @return
     */
    public boolean deletePosition(int id);

    /**
     * 修改职位信息
     * @param oldId
     * @param newId
     * @param name
     * @param description
     * @return
     */
    public boolean updatePosition(int oldId, int newId, String name, String description);
}
