package com.service.client.infrastucture.out.mongodb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.service.client.domain.model.order.Order;
import com.service.client.infrastucture.out.mongodb.entity.EntityOrder;

@Mapper(componentModel ="spring")
public interface OrderEntityMapper {
    OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);

    EntityOrder toEntityOrder(Order order);
    Order toOrder(EntityOrder entityOrder);
}

