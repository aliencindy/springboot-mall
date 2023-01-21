package com.chrissy.springbootmall.dao;

import com.chrissy.springbootmall.dto.ProductRequest;
import com.chrissy.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
