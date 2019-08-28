package com.yuwendeng.dao;

import com.yuwendeng.domain.Book;

import java.util.List;

public interface ProductDao {
    /*
    查询所有
     */
    public List<Book> findAll();
}
