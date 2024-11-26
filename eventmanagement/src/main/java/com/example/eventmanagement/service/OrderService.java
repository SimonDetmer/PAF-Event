package com.example.eventmanagement.service;

import com.example.eventmanagement.entities.Order;
import com.example.eventmanagement.entities.Ticket;
import com.example.eventmanagement.entities.User;
import com.example.eventmanagement.entities.Event;
import com.example.eventmanagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(User user, Event event, List<Ticket> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("Cannot create an order without tickets.");
        }

        Order order = new Order(user, event, tickets);
        orderRepository.save(order); // Save to the database
        return order;
    }

    public Order finalizeOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));

        order.finalizeOrder();
        orderRepository.save(order); // Save the updated state
        return order;
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found."));

        order.cancelOrder();
        orderRepository.save(order); // Save the updated state
    }
}
