package com.yuwendeng.dao.impl;

import com.yuwendeng.dao.ProductDao;
import com.yuwendeng.domain.Book;
import com.yuwendeng.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Book> findAll() {
        String sql = "select * form books";
        return  template.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
    }
}
