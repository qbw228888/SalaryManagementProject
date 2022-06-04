package com.SalaryManagement.Dao.Impl;

import com.SalaryManagement.Dao.PositionDao;
import com.SalaryManagement.Domain.Position;
import com.SalaryManagement.util.DruidUtils;
import javafx.geometry.Pos;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    private DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(DruidUtils.getDataSource());

    public List<Position> getPositionList() {
        String sql = "select * from tab_position";
        List<Position> query = template.query(sql, new BeanPropertyRowMapper<Position>(Position.class));
        return query;
    }

    public Position getPosition(int id) {
        String sql = "select * from tab_position where id = ?";
        List<Position> query = template.query(sql, new BeanPropertyRowMapper<Position>(Position.class), id);
        if (query.size() == 0){
            return null;
        } else{
            return query.get(0);
        }
    }

    public boolean addPosition(Position position) {
        List params = new ArrayList();
        params.add(position.getId());
        params.add(position.getName());
        params.add(position.getDescription());
        String sql = "insert into tab_position values(?,?,?)";
        int update = template.update(sql, params.toArray());
        if (update == 1){
            return true;
        } else{
            return false;
        }
    }

    public boolean deletePosition(int id) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;// 返回事务对象;
        String sql1 = "select name from tab_position where id = ?";
        String sql2 = "delete from tab_position where id = ?";
        String sql3 = "update tab_employee set position = 'null' where position like ?";
        try {
            status = transactionManager.getTransaction(def);// 返回事务对象;
            String positionName = template.queryForObject(sql1, String.class, id);
            int updatePos = template.update(sql2, id);
            int updateEmp = template.update(sql3, positionName);
            transactionManager.commit(status);
            if (updatePos == 1){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        return false;
    }

    public boolean updatePosition(int oldId, Position position) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;// 返回事务对象;
        String sql1 = "select name from tab_position where id = ?";
        String sql2 = "update tab_position set id=?, name=?, description=? where id=?";
        String sql3 = "update tab_employee set position = ? where position like ?";
        try {
            status = transactionManager.getTransaction(def);// 返回事务对象;
            String positionName = template.queryForObject(sql1, String.class, oldId);
            int updatePos = template.update(sql2, position.getId(), position.getName(), position.getDescription(), oldId);
            int updateEmp = template.update(sql3, position.getName(),positionName);
            transactionManager.commit(status);
            if (updatePos == 1){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        return false;
    }
}
