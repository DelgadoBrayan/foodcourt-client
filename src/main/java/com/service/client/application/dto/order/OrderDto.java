package com.service.client.application.dto.order;

import java.util.List;

import com.service.client.application.dto.dish.DishDto;

import lombok.Data;

@Data
public class OrderDto {
    private String id;
    private Long idRestaurant;
    private Long idClient;
    private Number quantity;
    private List<DishDto> dishes;
    private String status;
    private Long employeeAssignedId;
}
