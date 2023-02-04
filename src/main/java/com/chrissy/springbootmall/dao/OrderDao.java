package com.chrissy.springbootmall.dao;

import com.chrissy.springbootmall.dto.CreateOrderRequest;
import com.chrissy.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

}
