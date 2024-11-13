package com.example.eventmanagement.entities;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

    // Constructors, Getters, and Setters

    public Ticket() {
    }

    public Ticket(Long eventId, BigDecimal price, TicketStatus status) {
        this.eventId = eventId;
        this.price = price;
        this.status = status;
    }

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

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    // Methods for ticket operations
    public void reserve() {
        if (this.status == TicketStatus.AVAILABLE) {
            this.status = TicketStatus.RESERVED;
        }
    }

    public void purchase() {
        if (this.status == TicketStatus.RESERVED) {
            this.status = TicketStatus.PURCHASED;
        }
    }
}