package com.chrissy.springbootmall.service;

import com.chrissy.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
}
