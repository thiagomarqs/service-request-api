package com.example.servicerequestapi.usecases;

import com.example.servicerequestapi.entity.Queue;
import com.example.servicerequestapi.entity.Ticket;
import com.example.servicerequestapi.entity.User;
import com.example.servicerequestapi.entity.ticketstatus.Draft;
import com.example.servicerequestapi.entity.ticketstatus.InProgress;
import com.example.servicerequestapi.repository.TicketRepository;
import com.example.servicerequestapi.repository.CategorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ManageTicket {

    private TicketRepository ticketRepository;
    private CategorizationRepository categorizationRepository;

    public ManageTicket() {}

    @Autowired
    public ManageTicket(TicketRepository ticketRepository, CategorizationRepository categorizationRepository) {
        this.ticketRepository = ticketRepository;
        this.categorizationRepository = categorizationRepository;
    }

    public Ticket openTicket(Ticket ticket, User requestedBy) {
        ticket.setRequested(requestedBy);
        ticket.setModified(requestedBy);
        Queue queue = categorizationRepository.getQueue(ticket);
        ticket.setQueue(queue);
        ticket.setStatus(new InProgress());

        return ticketRepository.save(ticket);
    }

    public Ticket saveDraft(Ticket ticket, User requestedBy) {
        ticket.setStatus(new Draft());
        ticket.setRequested(requestedBy);
        ticket.setModified(requestedBy);

        return ticketRepository.save(ticket);
    }

}
