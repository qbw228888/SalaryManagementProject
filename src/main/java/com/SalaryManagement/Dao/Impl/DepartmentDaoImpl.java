package com.SalaryManagement.Dao.Impl;

import com.SalaryManagement.Dao.DepartmentDao;
import com.SalaryManagement.Domain.Department;
import com.SalaryManagement.util.DruidUtils;
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
public class DepartmentDaoImpl implements DepartmentDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    private DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(DruidUtils.getDataSource());
    public List<Department> getDepartments() {
        String sql = "select * from tab_department";
        List<Department> query = template.query(sql, new BeanPropertyRowMapper<Department>(Department.class));
        return query;
    }

    public Department getDepartment(int id) {
        String sql = "select * from tab_department where id = ?";
        List<Department> query = template.query(sql, new BeanPropertyRowMapper<Department>(Department.class), id);
        if (query.size() > 0){
            return query.get(0);
        } else {
            return null;
        }
    }

    public boolean addDepartment(Department department) {
        String sql = "insert into tab_department values(?,?,?)";
        List params = new ArrayList();
        params.add(department.getId());
        params.add(department.getName());
        params.add(department.getCount());
        int update = template.update(sql, params.toArray());
        if (update == 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteDepartment(int id){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;// 返回事务对象;
        String sql1 = "select name from tab_department where id = ?";
        String sql2 = "delete from tab_department where id = ?";
        String sql3 = "update tab_employee set department = 'null' where department like ?";
        try {
            status = transactionManager.getTransaction(def);// 返回事务对象;
            String departmentName = template.queryForObject(sql1, String.class, id);
            int updateDep = template.update(sql2, id);
            int updateEmp = template.update(sql3, departmentName);
            transactionManager.commit(status);
            if (updateDep == 1){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        return false;
    }

    public boolean updateDepartment(int oldId, Department department) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = null;// 返回事务对象;
        String sql1 = "select name from tab_department where id = ?";
        String sql2 = "update tab_department set id=?, name=?, count=? where id=?";
        String sql3 = "update tab_employee set department = ? where department like ?";
        try {
            status = transactionManager.getTransaction(def);// 返回事务对象;
            String departmentName = template.queryForObject(sql1, String.class, oldId);
            int updateDep = template.update(sql2, department.getId(), department.getName(), department.getCount(), oldId);
            int updateEmp = template.update(sql3, department.getName(),departmentName);
            transactionManager.commit(status);
            if (updateDep == 1){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        return false;
    }

//    public static void main(String[] args) {
//        DepartmentDao dao = new DepartmentDaoImpl();
//        System.out.println(dao.getDepartment(1));
//    }
}
