package com.service.client.domain.usecase;

import org.springframework.stereotype.Service;

import com.service.client.domain.api.IOrderServicePort;
import com.service.client.domain.model.order.Order;
import com.service.client.domain.spi.IOrderPersistencePort;
import com.service.client.infrastucture.exception.InvalidOrderException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderUseCase implements IOrderServicePort{

    private static final String ORDER_READY = "Ready";
    private static final String ORDER_IN_PREPARATION = "In Preparation";
    private final IOrderPersistencePort orderPersistencePort;
    @Override
    public Order saveOrder(Order order) {
        if (order.getStatus() != ORDER_READY) { 
            order.setStatus("Pending");
            return orderPersistencePort.saveOrder(order);
        }else{ 
            throw new InvalidOrderException("The client already has an order in process.");
        } 

    }
    @Override
    public void updateOrderStatus(Long idOrder, String status) {
        
        Order currentOrder = orderPersistencePort.findOrderById(idOrder); 
        if (currentOrder != null) { 
            if ((currentOrder.getStatus().equals("Pending") && status.equals(ORDER_IN_PREPARATION)) || 
            (currentOrder.getStatus().equals(ORDER_IN_PREPARATION) && status.equals(ORDER_READY)) || 
            (currentOrder.getStatus().equals(ORDER_READY) && status.equals("Delivered"))) { 
                currentOrder.setStatus(status); 
                orderPersistencePort.saveOrder(currentOrder);
 
            } else {
                throw new InvalidOrderException("Invalid status transition.");
        }
        }
    }
    @Override
    public Order findOrderById(Long id) {
       if (id == null) {
         throw new InvalidOrderException("Id no puede ser null");
       }
       return orderPersistencePort.findOrderById(id);
    }


}
