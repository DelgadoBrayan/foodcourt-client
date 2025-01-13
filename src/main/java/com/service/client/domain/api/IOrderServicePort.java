package com.service.client.domain.api;

import java.util.List;

import com.service.client.domain.model.order.Order;

public interface IOrderServicePort {
    Order createOrder(Order order);
    void assignEmployeeToOrder(String orderId, Long employeeId, Long restaurantId); 
    Order findOrderById(String id);
    List<Order> listOrders(int page, int size, String status, Long restaurantId);
}
