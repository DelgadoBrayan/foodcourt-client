package com.service.client.infrastucture.input.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.client.application.dto.order.OrderDto;
import com.service.client.application.handler.OrderHandler;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderHandler orderHandler;

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderHandler.createOrder(orderDto);
    }

    @PatchMapping("/{idOrder}/status")
    public OrderDto updateOrderStatus(@PathVariable Long idOrder, @RequestBody String status) {
        return orderHandler.updateOrderStatus(idOrder, status);
    }

    @GetMapping("/{idOrder}")
    public OrderDto getOrderById(@PathVariable Long idOrder) {
        return orderHandler.findOrderById(idOrder);
    }
}
