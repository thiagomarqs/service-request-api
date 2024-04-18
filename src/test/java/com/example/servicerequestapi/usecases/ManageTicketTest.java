package com.example.servicerequestapi.usecases;

import com.example.servicerequestapi.entity.*;
import com.example.servicerequestapi.entity.ticketstatus.Draft;
import com.example.servicerequestapi.entity.ticketstatus.InProgress;
import com.example.servicerequestapi.repository.CategorizationRepository;
import com.example.servicerequestapi.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManageTicketTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private CategorizationRepository categorizationRepository;

    @InjectMocks
    private ManageTicket manageTicket = new ManageTicket();

    @Test
    void openTicket() {

        User requestedBy = new User();
        Ticket ticket = Ticket.builder()
                .requestedFor(new User())
                .category(new Category())
                .subcategory(new Subcategory())
                .title("Title")
                .description("Description")
                .build();

        when(categorizationRepository.getQueue(any())).thenReturn(new Queue());

        manageTicket.openTicket(ticket, requestedBy);

        assertNotNull(ticket.getId());
        assertNotNull(ticket.getRequestedBy());
        assertNotNull(ticket.getRequestedAt());
        assertNotNull(ticket.getModifiedBy());
        assertNotNull(ticket.getModifiedAt());
        assertNotNull(ticket.getQueue());
        assertInstanceOf(InProgress.class, ticket.getStatus());
    }

    @Test
    void saveDraft() {
        User requestedBy = new User();
        Ticket ticket = Ticket.builder()
                .title("Filling only the title")
                .build();

        manageTicket.saveDraft(ticket, requestedBy);

        assertNotNull(ticket.getRequestedBy());
        assertNotNull(ticket.getRequestedAt());
        assertNotNull(ticket.getModifiedBy());
        assertNotNull(ticket.getModifiedAt());
        assertInstanceOf(Draft.class, ticket.getStatus());
    }

}