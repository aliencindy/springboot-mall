package com.chrissy.springbootmall.service;

import com.chrissy.springbootmall.dto.ProductRequest;
import com.chrissy.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
