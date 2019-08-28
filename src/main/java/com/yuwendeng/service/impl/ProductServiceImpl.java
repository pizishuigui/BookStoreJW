package com.yuwendeng.service.impl;

import com.yuwendeng.dao.ProductDao;
import com.yuwendeng.dao.impl.ProductDaoImpl;
import com.yuwendeng.domain.Book;
import com.yuwendeng.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Book> findAll() {
        return productDao.findAll();
    }
}
