package com.service.client.infrastucture.out.mongodb.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
@Data
@Document(collection = "orders")
public class EntityOrder {
    @Id
    private String id;
    private Long idRestaurantLong;
    private Long idClient;
    private Number quantity;
    private List<Long> orders;
    private String status;

}