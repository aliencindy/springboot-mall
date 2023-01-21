package com.chrissy.springbootmall.service.impl;

import com.chrissy.springbootmall.dao.ProductDao;
import com.chrissy.springbootmall.dto.ProductRequest;
import com.chrissy.springbootmall.model.Product;
import com.chrissy.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {


        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
