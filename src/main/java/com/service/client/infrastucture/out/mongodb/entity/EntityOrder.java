package com.service.client.infrastucture.out.mongodb.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.service.client.domain.model.order.OrderStatus;

import lombok.Data;
@Data
@Document(collection = "orders")
public class EntityOrder {
    @Id
    private String id;
    private Long idRestaurantLong;
    private Long idClient;
    private Number quantity;
    private List<Long> dishes;
    private OrderStatus status;
    private Long employeeAssignedId;
}
