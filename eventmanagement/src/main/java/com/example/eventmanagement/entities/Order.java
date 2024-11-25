package com.example.eventmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.math.BigDecimal;

import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;  // Relationship to the User entity

    @ManyToOne
    private Event event;  // Relationship to the Event entity

    @OneToMany
    private List<Ticket> listOfTickets;  // List of Tickets related to this Order

    @Transient
    private float totalPrice;  // Temporary field, calculated dynamically

    // Constructor
    public Order() {}

    public Order(User user, Event event, List<Ticket> listOfTickets) {
        this.user = user;
        this.event = event;
        this.listOfTickets = listOfTickets;
        this.totalPrice = calculateTotalPrice();
    }

    // Methods

    public float calculateTotalPrice() {
        BigDecimal total = BigDecimal.ZERO; // Start with BigDecimal.ZERO

        for (Ticket ticket : listOfTickets) {
            total = total.add(ticket.getPrice()); // Directly use BigDecimal from getPrice()
        }

        return total.floatValue(); // Convert back to float if necessary
    }


    // Create the order and set the total price
    public void createOrder() {
        // You can add order creation logic here, such as checking availability
        this.totalPrice = calculateTotalPrice();
    }

    // Finalize the order (e.g., confirm purchase, initiate payment)
    public void finalizeOrder() {
        // Logic to finalize the order (could involve payment or sending confirmation)
    }

    // Cancel the order (e.g., free up tickets, refund)
    public void cancelOrder() {
        // Logic to cancel the order
        // Optionally, refund the user and free the tickets
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

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
