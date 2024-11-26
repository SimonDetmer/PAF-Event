package com.example.eventmanagement.controller;

import com.example.eventmanagement.entities.Order;
import com.example.eventmanagement.entities.Ticket;
import com.example.eventmanagement.entities.User;
import com.example.eventmanagement.entities.Event;
import com.example.eventmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint to create an order
    @PostMapping("/create")
    public Order createOrder(
            @RequestBody User user,
            @RequestBody Event event,
            @RequestBody List<Ticket> tickets) {
        return orderService.createOrder(user, event, tickets);
    }

    // Endpoint to finalize an order
    @PutMapping("/finalize/{orderId}")
    public Order finalizeOrder(@PathVariable Long orderId) {
        return orderService.finalizeOrder(orderId);
    }

    // Endpoint to cancel an order
    @PutMapping("/cancel/{orderId}")
    public void cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
    }
}
