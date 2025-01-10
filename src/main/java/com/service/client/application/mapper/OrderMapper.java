package com.service.client.application.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.service.client.application.dto.order.OrderDto;
import com.service.client.domain.model.order.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toOrderDto(Order order);
    Order toOrder(OrderDto orderDto);

    List<OrderDto> toOrderDtoList(List<Order> orders); 
    List<Order> toOrderList(List<OrderDto> orderDtos);
}
