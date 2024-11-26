package com.example.eventmanagement.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    @OneToMany
    private List<Ticket> listOfTickets;

    @Transient
    private BigDecimal totalPrice;

    // Constructors
    public Order() {}

    public Order(User user, Event event, List<Ticket> listOfTickets) {
        this.user = user;
        this.event = event;
        this.listOfTickets = listOfTickets;
        this.totalPrice = calculateTotalPrice();
    }

    // Method to calculate the total price of the order
    public BigDecimal calculateTotalPrice() {
        return listOfTickets.stream()
                .map(Ticket::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 1. Create Order
    public void createOrder(User user, Event event, List<Ticket> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("Cannot create an order without tickets.");
        }
        this.user = user;
        this.event = event;
        this.listOfTickets = tickets;
        this.totalPrice = calculateTotalPrice();
        System.out.println("Order created successfully with total price: " + totalPrice);
    }

    // 2. Finalize Order
    public void finalizeOrder() {
        if (listOfTickets == null || listOfTickets.isEmpty()) {
            throw new IllegalStateException("Cannot finalize an order without tickets.");
        }

        // Simulate ticket reservation or payment logic
        for (Ticket ticket : listOfTickets) {
            ticket.purchase(); // Mark tickets as purchased
        }
        System.out.println("Order finalized successfully.");
    }

    // 3. Cancel Order
    public void cancelOrder() {
        if (listOfTickets == null || listOfTickets.isEmpty()) {
            throw new IllegalStateException("Cannot cancel an order without tickets.");
        }

        // Release tickets back to the system
        for (Ticket ticket : listOfTickets) {
            ticket.reserve(); // Reset ticket status to reserved
        }
        System.out.println("Order cancelled successfully. Tickets are released back to the system.");
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Ticket> getListOfTickets() {
        return listOfTickets;
    }

    public void setListOfTickets(List<Ticket> listOfTickets) {
        this.listOfTickets = listOfTickets;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
