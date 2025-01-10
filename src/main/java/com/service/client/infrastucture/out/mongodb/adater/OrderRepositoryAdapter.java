package com.service.client.infrastucture.out.mongodb.adater;

import java.util.Optional;

import com.service.client.domain.model.order.Order;
import com.service.client.domain.spi.IOrderPersistencePort;
import com.service.client.infrastucture.exception.InvalidOrderException;
import com.service.client.infrastucture.out.mongodb.entity.EntityOrder;
import com.service.client.infrastucture.out.mongodb.mapper.OrderEntityMapper;
import com.service.client.infrastucture.out.mongodb.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryAdapter implements IOrderPersistencePort {

    private final OrderRepository  orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    @Override
    public Order saveOrder(Order order) {
        EntityOrder entityOrder = OrderEntityMapper.INSTANCE.toEntityOrder(order);
        EntityOrder savedEntityOrder = orderRepository.save(entityOrder);
        return orderEntityMapper.toOrder(savedEntityOrder);
    }

@Override
public void updateOrderStatus(Long idOrder, String status) {
    Optional<EntityOrder> entityOrderOptional = orderRepository.findById(idOrder.toString());
    if (entityOrderOptional.isPresent()) {
        EntityOrder entityOrder = entityOrderOptional.get();
        entityOrder.setStatus(status);
        orderRepository.save(entityOrder);
    } else {
        throw new InvalidOrderException("Order not found for ID: " + idOrder);
    }
}


    @Override
    public Order findOrderById(Long id) {
        Optional<EntityOrder> entityOrderOptional = orderRepository.findById(id.toString());
        return entityOrderOptional.map(OrderEntityMapper.INSTANCE::toOrder).orElse(null);
    }

}

