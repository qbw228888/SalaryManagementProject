package com.SalaryManagement.Dao.Impl;

import com.SalaryManagement.Dao.SalaryDao;
import com.SalaryManagement.Domain.Employee;
import com.SalaryManagement.Domain.Salary;
import com.SalaryManagement.util.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalaryDaoImpl implements SalaryDao {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    public List<Salary> getSalaries(int eid, String name, String salaryTime, int scale) {
        StringBuffer sql = new StringBuffer
                ("select s.*, e.name, e.scale" +
                        " from tab_salary s join tab_employee e on s.eid = e.id where 1 = 1");
        Boolean flag = false;
        List params = new ArrayList();
        if (eid != 0){
            sql.append(" and s.eid = ?");
            params.add(eid);
            flag = true;
        }
        if (salaryTime != null && salaryTime.length()>0){
            sql.append(" and s.salaryTime like ?");
            params.add("%"+salaryTime+"%");//拼接了模糊查询的两个%
            flag = true;
        }
        if (name != null && name.length()>0){
            sql.append(" and e.name like ?");
            params.add("%"+name+"%");//拼接了模糊查询的两个%
            flag = true;
        }
        if (scale != 0){
            sql.append(" and e.scale = ?");
            params.add(scale);
            flag = true;
        }
        String finalSql = sql.toString();
        System.out.println(finalSql);
        List<Salary> query = null;
        if (flag) {
            query = template.query(finalSql, new BeanPropertyRowMapper<Salary>(Salary.class), params.toArray());
        } else {
            query = template.query(finalSql, new BeanPropertyRowMapper<Salary>(Salary.class));
        }
        return query;
    }

    public boolean deleteSalary(int eid, String salaryTime) {
        String sql = "delete from tab_salary where eid = ? and salaryTime like ?";
        List params = new ArrayList();
        params.add(eid);
        params.add("%"+salaryTime+"%");
        int update = template.update(sql, params.toArray());
        if (update == 1){
            return true;
        } else{
            return false;
        }
    }

    public double getBaseSalary(int eid) {
        String sql1 = "select scale from tab_employee where id = ?";
        String sql2 = "select salary from tab_scale where id = ?";
        try {
            Integer scale = template.queryForObject(sql1, Integer.class, eid);
            Double baseSalary = template.queryForObject(sql2, Double.class, scale);
            return baseSalary;
        } catch (Exception e){
            return 0;
        }
    }

    public boolean addSalary(int eid, String salaryTime, double baseSalary, double allowance, double deduction, double realSalary) {
        String sql = "insert into tab_salary values(?,?,?,?,?,?)";
        List params = new ArrayList();
        params.add(eid);
        params.add(salaryTime);
        params.add(baseSalary);
        params.add(allowance);
        params.add(deduction);
        params.add(realSalary);
        int update = template.update(sql, params.toArray());
        if (update == 1){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateSalary(int eid, String salaryTime, double allowance, double deduction, double realSalary) {
        String sql = "update tab_salary set allowance=?, deduction=?, realSalary=? where eid=? and salaryTime=?";
        List params = new ArrayList();
        params.add(allowance);
        params.add(deduction);
        params.add(realSalary);
        params.add(eid);
        params.add(salaryTime);
        int update = template.update(sql, params.toArray());
        if (update == 1){
            return true;
        }else {
            return false;
        }
    }

//    @Test
//    public void test(){
//        SalaryDao dao = new SalaryDaoImpl();
//        List<Salary> salaries = dao.getSalaries(0, null, null, 0);
//        for (Salary s:salaries
//             ) {
//            System.out.println(s);
//        }
//    }
}
