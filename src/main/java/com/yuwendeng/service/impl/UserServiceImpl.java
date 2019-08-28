package com.yuwendeng.service.impl;

import com.yuwendeng.dao.UserDao;
import com.yuwendeng.dao.impl.UserDaoImpl;
import com.yuwendeng.domain.User;
import com.yuwendeng.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) {
        User u = null;
        UserDao userDao = new UserDaoImpl();
        user =userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        return user;
    }
}
