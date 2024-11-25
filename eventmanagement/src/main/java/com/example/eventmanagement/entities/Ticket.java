package com.example.eventmanagement.entities;

import com.example.eventmanagement.states.*;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    @Column(nullable = false)
    private BigDecimal price;

    @Transient  // State is not persisted in the database
    private TicketState state;

    // Constructors
    public Ticket() {
        this.state = new AvailableState(); // Default state
    }

    public Ticket(Long eventId, BigDecimal price) {
        this.eventId = eventId;
        this.price = price;
        this.state = new AvailableState(); // Default state
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TicketState getState() {
        return state;
    }

    public void setState(TicketState state) {
        this.state = state;
    }

    // Delegating state-specific behaviors
    public void reserve() {
        state.reserve(this);
    }

    public void purchase() {
        state.purchase(this);
    }
}
