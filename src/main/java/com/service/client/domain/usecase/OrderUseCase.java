package com.service.client.domain.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.client.domain.api.IOrderServicePort;
import com.service.client.domain.model.order.Order;
import com.service.client.domain.model.order.OrderStatus;
import com.service.client.domain.spi.IOrderPersistencePort;
import com.service.client.infrastucture.exception.InvalidOrderException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderUseCase implements IOrderServicePort {

    private final IOrderPersistencePort orderPersistencePort;
    @Override
    public Order createOrder(Order order) {
        return orderPersistencePort.saveOrder(order);
    }

    @Override
    public Order findOrderById(String id) {
        return orderPersistencePort.findOrderById(id);
    }

    @Override
    public List<Order> listOrders(int page, int size, String status, Long restaurantId) {
        try {
            OrderStatus orderStatus = status != null ? OrderStatus.valueOf(status) : null;
            return orderPersistencePort.listOrders(page, size, orderStatus, restaurantId);
        } catch (IllegalArgumentException e) {
            throw new InvalidOrderException("Status not valid");
        }
    }

    @Override
    public void assignEmployeeToOrder(String orderId, Long employeeId, Long restaurantId) {
        Order order = orderPersistencePort.findOrderById(orderId);

        if (!order.getIdRestaurant().equals(restaurantId)) {
            throw new InvalidOrderException("Employee does not belong to this restaurant");
        }

        order.setEmployeeAssignedId(employeeId);
        order.setStatus(OrderStatus.IN_PROCESS);
        orderPersistencePort.assignEmployeeToOrder(orderId, employeeId);
    }
   
}
