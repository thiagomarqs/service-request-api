package com.example.servicerequestapi.repository;

import com.example.servicerequestapi.entity.Queue;
import com.example.servicerequestapi.entity.Ticket;

public interface CategorizationRepository {

    Queue getQueue(Ticket ticket);

}
