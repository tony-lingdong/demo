package com.hld.service.impl;

import com.hld.entities.Order;
import com.hld.entities.OrderItems;
import com.hld.mapper.OrderItemMapper;
import com.hld.mapper.OrderMapper;
import com.hld.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Override
    public List<Order> getAllOrder(int user_id) {
        return orderMapper.getAllOrder(user_id);
    }

    @Override
    public void InsertOrder(Order order) {
        orderMapper.InsertOrder(order);
    }

    @Override
    public void InsertOrderItems(OrderItems orderItems) {
        orderItemMapper.InsertOrderItems(orderItems);
    }

    @Override
    public List<OrderItems> getAllOrderItems(int order_id) {
        return orderItemMapper.getAllOrderItems(order_id);
    }
}
