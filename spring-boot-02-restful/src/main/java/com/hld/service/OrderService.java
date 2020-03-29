package com.hld.service;

import com.hld.entities.Order;
import com.hld.entities.OrderItems;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder(int user_id);
    void InsertOrder(Order order);
    void InsertOrderItems(OrderItems orderItems);
    List<OrderItems> getAllOrderItems(int order_id);
}
