package com.example.eventmanagement.states;

import com.example.eventmanagement.entities.Ticket;

public class PurchasedState implements TicketState {
    @Override
    public void reserve(Ticket ticket) {
        System.out.println("Cannot reserve a purchased ticket.");
    }

    @Override
    public void purchase(Ticket ticket) {
        System.out.println("Ticket is already purchased.");
    }
}
