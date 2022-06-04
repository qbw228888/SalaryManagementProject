package com.SalaryManagement.Dao.Impl;

import com.SalaryManagement.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.SalaryManagement.Dao.UserDao;
import com.SalaryManagement.Domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    public User logIn(String username, String password) {
        String sql = "select * from tab_user where username = ? and password=?";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        if (query.size()>0){
            return query.get(0);
        } else {
            return null;
        }
    }

    public boolean saveUser(String username, String password) {
        String sql = "insert into tab_user values(?,?)";
        int update = template.update(sql, username, password);
        System.out.println(update);
        if (update == 1){
            return true;
        } else{
            return false;
        }
    }

    public List<User> findUsers(String username) {
        String sql = "select * from tab_user where username = ?";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class), username);
        return query;
    }
}
