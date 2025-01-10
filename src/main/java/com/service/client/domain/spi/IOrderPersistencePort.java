package com.service.client.domain.spi;


import com.service.client.domain.model.order.Order;

public interface IOrderPersistencePort {
    Order saveOrder(Order order); 
    Order findOrderById(Long id);
    void updateOrderStatus(Long orderId, String status);
}
