package com.example.servicerequestapi.repository;

import com.example.servicerequestapi.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
