package com.example.eventmanagement.states;

import com.example.eventmanagement.entities.Ticket;

public class AvailableState implements TicketState {
    @Override
    public void reserve(Ticket ticket) {
        ticket.setState(new ReservedState());
        System.out.println("Ticket reserved.");
    }

    @Override
    public void purchase(Ticket ticket) {
        System.out.println("Cannot purchase an available ticket. Reserve it first.");
    }
}
