package com.service.client.application.dto.order;

import java.util.List;


import lombok.Data;

@Data
public class OrderDto {
    private String id;
    private Long idRestaurantLong;
    private Long idClient;
    private Number quantity;
    private List<Long> orders;
    private String status;
}
