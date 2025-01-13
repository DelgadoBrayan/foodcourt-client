package com.service.client.infrastucture.input.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/{idOrder}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable String idOrder) {
        OrderDto orderDto = orderHandler.findOrderById(idOrder);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping 
    public List<OrderDto> listOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String status,
            @RequestParam Long restaurantId) {
        return orderHandler.listOrders(page, size, status, restaurantId);
    }
    @PatchMapping("/{orderId}/assign")
    public ResponseEntity<Void> assignEmployeeToOrder(@PathVariable String orderId, @RequestParam Long employeeId, @RequestParam Long restaurantId) {
        orderHandler.assignEmployeeToOrder(orderId, employeeId, restaurantId);
        return ResponseEntity.noContent().build();
    }
}