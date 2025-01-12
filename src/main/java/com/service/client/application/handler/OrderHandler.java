package com.service.client.application.handler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.service.client.application.dto.dish.DishDto;
import com.service.client.application.dto.order.OrderDto;
import com.service.client.application.mapper.DishMapper;
import com.service.client.application.mapper.OrderMapper;
import com.service.client.domain.api.IOrderServicePort;
import com.service.client.domain.model.dish.Dish;
import com.service.client.domain.model.order.Order;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional
public class OrderHandler {

    private final IOrderServicePort orderServicePort;
    private final OrderMapper orderMapper;
    private final DishMapper dishMapper;
    private final WebClient webClient;

    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toOrder(orderDto);
        Order newOrder = orderServicePort.createOrder(order);
        return orderMapper.toOrderDto(newOrder);
    }

    public OrderDto updateOrderStatus(String idOrder, String status) {
        orderServicePort.updateOrderStatus(idOrder, status);
        Order updatedOrder = orderServicePort.findOrderById(idOrder);
        return orderMapper.toOrderDto(updatedOrder);
    }

    public OrderDto findOrderById(String idOrder) {
        Order order = orderServicePort.findOrderById(idOrder);
        return orderMapper.toOrderDto(order);
    }

    public List<OrderDto> listOrders(int page, int size, String status, Long restaurantId) {
        List<Order> orders = orderServicePort.listOrders(page, size, status, restaurantId);

        return orders.stream().map(order -> {
            OrderDto orderDto = orderMapper.toOrderDto(order);
            if (order.getDishes() != null && !order.getDishes().isEmpty()) {
                List<Dish> dishes = getDishesFromExternalServiceBatch(order.getDishes());
                orderDto.setDishes(dishMapper.toDishDtoList(dishes));
            }
            return orderDto;
        }).toList();
    }

    public OrderDto findOrderByIdWithDishes(String idOrder) {
        Order order = orderServicePort.findOrderById(idOrder);
        OrderDto orderDto = orderMapper.toOrderDto(order);

        if (order.getDishes() != null && !order.getDishes().isEmpty()) {
            List<Dish> dishes = getDishesFromExternalServiceBatch(order.getDishes());
            orderDto.setDishes(dishMapper.toDishDtoList(dishes));
        }

        return orderDto;
    }

    private List<Dish> getDishesFromExternalServiceBatch(List<Long> dishIds) {
        String ids = dishIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        try {
            DishDto[] dishDtos = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/byIds")
                            .queryParam("ids", ids)
                            .build())
                    .retrieve()
                    .bodyToMono(DishDto[].class)
                    .block();

            return Arrays.stream(dishDtos != null ? dishDtos : new DishDto[0])
                    .map(dishMapper::toDish)
                    .toList();

        } catch (WebClientResponseException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}