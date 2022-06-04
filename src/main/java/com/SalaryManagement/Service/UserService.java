package com.SalaryManagement.Service;

public interface UserService {
    /**
     * 判断登录是否成功，成功返回ture
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password);

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public boolean register(String username, String password);
}
