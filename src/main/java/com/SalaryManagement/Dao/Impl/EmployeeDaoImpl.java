package com.SalaryManagement.Dao.Impl;

import com.SalaryManagement.Dao.EmployeeDao;
import com.SalaryManagement.Domain.Employee;
import com.SalaryManagement.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

    public List<Employee> getEmployees(int id, String name, String department, String position, int scale) {
        StringBuffer sql = new StringBuffer("select * from tab_employee where 1 = 1");
        Boolean flag = false;
        List params = new ArrayList();
        if (id != 0){
            sql.append(" and id = ?");
            params.add(id);
            flag = true;
        }
        if (name != null && name.length()>0){
            sql.append(" and name like ?");
            params.add("%"+name+"%");//拼接了模糊查询的两个%
            flag = true;
        }
        if (department != null && department.length()>0){
            sql.append(" and department like ?");
            params.add("%"+department+"%");//拼接了模糊查询的两个%
            flag = true;
        }
        if (position != null && position.length()>0){
            sql.append(" and position like ?");
            params.add("%"+position+"%");//拼接了模糊查询的两个%
            flag = true;
        }
        if (scale != 0){
            sql.append(" and scale = ?");
            params.add(scale);
            flag = true;
        }
        String finalSql = sql.toString();
        System.out.println(finalSql);
        List<Employee> query = null;
        for (Object o:params
             ) {
            System.out.println(o+","+o.getClass());
        }
        if (flag) {
            query = jdbcTemplate.query(finalSql, new BeanPropertyRowMapper<Employee>(Employee.class), params.toArray());
        } else {
            query = jdbcTemplate.query(finalSql, new BeanPropertyRowMapper<Employee>(Employee.class));
        }
        return query;
    }

    public int countEmployees() {
        String sql = "select count(*) from tab_employee";
        int result = jdbcTemplate.queryForObject(sql, Integer.class);
        return result;
    }

    public boolean addEmployee(Employee employee) {
        String sql = "insert into tab_employee values(?,?,?,?,?,?,?,?,?,?,?)";
        List params = new ArrayList();
        params.add(employee.getId());
        params.add(employee.getName());
        params.add(employee.getSex());
        params.add(employee.getBirth());
        params.add(employee.getEntry());
        params.add(employee.getAge());
        params.add(employee.getDepartment());
        params.add(employee.getPosition());
        params.add(employee.getScale());
        params.add(employee.getEmail());
        params.add(employee.getPhone());
        int update = jdbcTemplate.update(sql, params.toArray());
        if (update == 1){
            return true;
        } else{
            return false;
        }
    }

    public boolean deleteEmployee(int id) {
        String sql = "delete from tab_employee where id = ?";
        int update = jdbcTemplate.update(sql, id);
        if (update == 1){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateEmployee(Employee employee) {
        String sql = "update tab_employee set name=?, sex=?, birth=?, entry=?, age=?," +
                "department=?, position=?, scale=?, email=?, phone=? where id=?";
        List params = new ArrayList();
        params.add(employee.getName());
        params.add(employee.getSex());
        params.add(employee.getBirth());
        params.add(employee.getEntry());
        params.add(employee.getAge());
        params.add(employee.getDepartment());
        params.add(employee.getPosition());
        params.add(employee.getScale());
        params.add(employee.getEmail());
        params.add(employee.getPhone());
        params.add(employee.getId());
        int update = jdbcTemplate.update(sql, params.toArray());
        if (update == 1){
            return true;
        }else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        EmployeeDao dao = new EmployeeDaoImpl();
//        int i = dao.countEmployees();
//        System.out.println(i);
//    }
}
