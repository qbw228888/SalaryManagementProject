package com.SalaryManagement.Dao;

import com.SalaryManagement.Domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public User logIn(String username, String password);

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public boolean saveUser(String username, String password);

    /**
     * 根据用户名找用户
     * @param username
     * @return
     */
    public List<User> findUsers(String username);
}
