package com.SalaryManagement.Dao.Impl;

import com.SalaryManagement.Dao.ScaleDao;
import com.SalaryManagement.Domain.Salary;
import com.SalaryManagement.Domain.Scale;
import com.SalaryManagement.util.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import sun.java2d.loops.ScaledBlit;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ScaleDaoImpl implements ScaleDao {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    private DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(DruidUtils.getDataSource());

    public List<Scale> getScales() {
        String sql = "select * from tab_scale";
        List<Scale> query = template.query(sql, new BeanPropertyRowMapper<Scale>(Scale.class));
        return query;
    }

    public Scale getScale(int id) {
        String sql = "select * from tab_scale where id = ?";
        List<Scale> query = template.query(sql, new BeanPropertyRowMapper<Scale>(Scale.class), id);
        return query.get(0);
    }

    public boolean deleteScales(int id) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;// 返回事务对象;
        String sql1 = "delete from tab_scale where id = ?";
        String sql2 = "update tab_employee set scale = 0 where scale = ?";
        try {
            status = transactionManager.getTransaction(def);// 返回事务对象;
            int updateScale = template.update(sql1, id);
            int updateEmp = template.update(sql2, id);
            transactionManager.commit(status);
            if (updateScale == 1){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        return false;
    }

    public boolean addScale(Scale scale) {
        String sql = "insert into tab_scale values(?,?,?)";
        List params = new ArrayList();
        params.add(scale.getId());
        params.add(scale.getSalary());
        params.add(scale.getDescription());
        int update = template.update(sql, params.toArray());
        if (update == 1){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateScale(Scale scale) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;// 返回事务对象;
        //查出所有变动的工资记录
        String sql1 = "select s.*,e.name,e.scale from tab_salary s join tab_employee e on s.eid=e.id where e.scale = ?";
        //修改登记表
        String sql2 = "update tab_scale set salary=?, description=? where id=?";
        //修改工资记录表
        String sql3 = "update tab_salary set baseSalary=?, realSalary=? where eid=? and salaryTime=?";
        try {
            status = transactionManager.getTransaction(def);// 返回事务对象;
            List<Salary> salaries = template.query(sql1, new BeanPropertyRowMapper<Salary>(Salary.class), scale.getId());
            for (Salary s: salaries) {
                s.setBaseSalary(scale.getSalary());
                s.setRealSalary(s.getBaseSalary()+s.getAllowance()-s.getDeduction());
            }
            int updateScale = template.update(sql2, scale.getSalary(), scale.getDescription(), scale.getId());
            for (Salary s :salaries){
                template.update(sql3,s.getBaseSalary(),s.getRealSalary(),s.getEid(),s.getSalaryTime());
            }
            transactionManager.commit(status);
            if (updateScale == 1){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        return false;
    }

//    @Test
//    public void test(){
//        ScaleDao dao = new ScaleDaoImpl();
//        Scale scale = dao.getScale(4);
//        System.out.println(scale);
//    }
}
