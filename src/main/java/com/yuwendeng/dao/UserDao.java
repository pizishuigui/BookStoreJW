package com.yuwendeng.dao;

import com.yuwendeng.domain.User;

public interface UserDao {
    public User findByUsernameAndPassword(String username, String password);

}
