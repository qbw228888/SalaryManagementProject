package com.SalaryManagement.Service.Impl;

import com.SalaryManagement.Dao.Impl.UserDaoImpl;
import com.SalaryManagement.Dao.UserDao;
import com.SalaryManagement.Domain.User;
import com.SalaryManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public boolean login(String username, String password) {
        User user = userDao.logIn(username, password);
        if (user != null){
            return true;
        } else{
            return false;
        }
    }

    public boolean register(String username, String password) {
        List<User> users = userDao.findUsers(username);
        if (users.size() > 0){
            return false;
        } else {
            boolean flag = userDao.saveUser(username, password);
            return flag;
        }
    }
}
