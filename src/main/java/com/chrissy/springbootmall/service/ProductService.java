package com.chrissy.springbootmall.service;

import com.chrissy.springbootmall.dto.ProductRequest;
import com.chrissy.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProduct(Integer productId);

}
