package com.example.eventmanagement.states;

import com.example.eventmanagement.entities.Ticket;

public class ReservedState implements TicketState {
    @Override
    public void reserve(Ticket ticket) {
        System.out.println("Ticket is already reserved.");
    }

    @Override
    public void purchase(Ticket ticket) {
        ticket.setState(new PurchasedState());
        System.out.println("Ticket purchased.");
    }
}
