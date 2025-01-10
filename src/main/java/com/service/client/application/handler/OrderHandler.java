package com.service.client.application.handler;

import org.springframework.stereotype.Service;

import com.service.client.application.dto.order.OrderDto;
import com.service.client.application.mapper.OrderMapper;
import com.service.client.domain.api.IOrderServicePort;
import com.service.client.domain.model.order.Order;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderHandler {
    
    private final IOrderServicePort orderServicePort;

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.INSTANCE.toOrder(orderDto);
        Order newOrder = orderServicePort.saveOrder(order);
        return OrderMapper.INSTANCE.toOrderDto(newOrder);
    }

    public OrderDto updateOrderStatus(Long idOrder, String status) {
        orderServicePort.updateOrderStatus(idOrder, status);
        Order updatedOrder = orderServicePort.findOrderById(idOrder);
        return OrderMapper.INSTANCE.toOrderDto(updatedOrder);
    }

    public OrderDto findOrderById(Long idOrder) {
        Order order = orderServicePort.findOrderById(idOrder);
        return OrderMapper.INSTANCE.toOrderDto(order);
    }
}
