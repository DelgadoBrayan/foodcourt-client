package com.service.client.domain.spi;


import java.util.List;

import com.service.client.domain.model.order.Order;
import com.service.client.domain.model.order.OrderStatus;

public interface IOrderPersistencePort {
    Order saveOrder(Order order);
    void assignEmployeeToOrder(String orderId, Long employeeId);
    Order findOrderById(String id);
    List<Order> listOrders(int page, int size, OrderStatus status, Long restaurantId);
}
