package com.service.client.infrastucture.out.mongodb.adater;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.service.client.domain.model.order.Order;
import com.service.client.domain.model.order.OrderStatus;
import com.service.client.domain.spi.IOrderPersistencePort;
import com.service.client.infrastucture.exception.InvalidOrderException;
import com.service.client.infrastucture.out.mongodb.entity.EntityOrder;
import com.service.client.infrastucture.out.mongodb.mapper.OrderEntityMapper;
import com.service.client.infrastucture.out.mongodb.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryAdapter implements IOrderPersistencePort {

    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    @Override
    public Order saveOrder(Order order) {
        EntityOrder entityOrder = orderEntityMapper.toEntityOrder(order);
        EntityOrder savedEntityOrder = orderRepository.save(entityOrder);
        return orderEntityMapper.toOrder(savedEntityOrder);
    }


    @Override
    public Order findOrderById(String id) {
        Optional<EntityOrder> entityOrderOptional = orderRepository.findById(id);
        return entityOrderOptional.map(orderEntityMapper::toOrder).orElse(null);
    }

    @Override
    public List<Order> listOrders(int page, int size, OrderStatus status, Long restaurantId) {
        Page<EntityOrder> entityOrders = orderRepository.findByStatusAndIdRestaurantLong(status, restaurantId, PageRequest.of(page, size));
        return entityOrders.stream().map(orderEntityMapper::toOrder).toList();
    }

     @Override
    public void assignEmployeeToOrder(String orderId, Long employeeId) {
        Optional<EntityOrder> entityOrderOptional = orderRepository.findById(orderId);
        if (entityOrderOptional.isPresent()) {
            EntityOrder entityOrder = entityOrderOptional.get();
            entityOrder.setEmployeeAssignedId(employeeId);
            entityOrder.setStatus(OrderStatus.IN_PROCESS);
            orderRepository.save(entityOrder);
        } else {
            throw new EntityNotFoundException("Order not found with id: " + orderId);
        }
    }
}

