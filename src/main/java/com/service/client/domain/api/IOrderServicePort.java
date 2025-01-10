package com.service.client.domain.api;

import com.service.client.domain.model.order.Order;

public interface IOrderServicePort {
    Order saveOrder(Order order);
    void updateOrderStatus(Long orderId, String status); 
    Order findOrderById(Long id);
}
