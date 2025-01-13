package com.service.client.application.mapper;
import java.util.Collections;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.service.client.application.dto.dish.DishDto;
import com.service.client.application.dto.order.OrderDto;
import com.service.client.domain.model.order.Order;
import com.service.client.domain.model.order.OrderStatus;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "status", target = "status", qualifiedByName = "mapOrderStatusToString")
    @Mapping(target = "dishes", ignore = true) 
    @Mapping(source = "employeeAssignedId", target = "employeeAssignedId")
    OrderDto toOrderDto(Order order);

    @Mapping(source = "status", target = "status", qualifiedByName = "mapStringToOrderStatus")
    @Mapping(source = "dishes", target = "dishes", qualifiedByName = "mapDishDtosToIds")
    @Mapping(source = "employeeAssignedId", target = "employeeAssignedId")
    Order toOrder(OrderDto orderDto);

    List<OrderDto> toOrderDtoList(List<Order> orders);

    @Named("mapOrderStatusToString")
    default String mapOrderStatusToString(OrderStatus status) {
        return status != null ? status.toString() : null;
    }

    @Named("mapStringToOrderStatus")
    default OrderStatus mapStringToOrderStatus(String status) {
        try {
            return status != null ? OrderStatus.valueOf(status) : null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Named("mapDishDtosToIds")
    default List<Long> mapDishDtosToIds(List<DishDto> dishDtos) {
        return dishDtos != null ? dishDtos.stream().map(DishDto::getId).toList() : Collections.emptyList();
    }
}