package com.service.client.infrastucture.out.mongodb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.service.client.domain.model.order.Order;
import com.service.client.infrastucture.out.mongodb.entity.EntityOrder;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {

    @Mapping(source = "idRestaurant", target = "idRestaurantLong")
    EntityOrder toEntityOrder(Order order);

    @Mapping(source = "idRestaurantLong", target = "idRestaurant")
    Order toOrder(EntityOrder entityOrder);
}
