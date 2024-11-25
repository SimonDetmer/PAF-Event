package com.example.eventmanagement.states;

import com.example.eventmanagement.entities.Ticket;

public interface TicketState {
    void reserve(Ticket ticket);
    void purchase(Ticket ticket);
}
