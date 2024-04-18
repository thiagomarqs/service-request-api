package com.example.servicerequestapi.entity.ticketstatus;

import com.example.servicerequestapi.entity.Ticket;
import com.example.servicerequestapi.entity.TicketStatus;

public class Solved implements TicketStatus {

    private Ticket ticket;

    @Override
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
