package com.yuwendeng.dao.impl;

import com.yuwendeng.dao.UserDao;
import com.yuwendeng.domain.User;
import com.yuwendeng.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            String sql="select * from user where username = ? and password = ?";
            user=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (DataAccessException e) {
            System.out.println("查询代码才出错");
        }
        return user;
    }
}
