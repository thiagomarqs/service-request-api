package com.example.servicerequestapi.entity;

import com.example.servicerequestapi.entity.ticketstatus.New;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {

    private Long id = 1L;
    private String title = "";
    private String description = "";
    private User requestedBy = new User();
    private User requestedFor = new User();
    private LocalDateTime requestedAt = LocalDateTime.now();
    private User modifiedBy = new User();
    private LocalDateTime modifiedAt = LocalDateTime.now();
    private Category category = new Category();
    private Subcategory subcategory = new Subcategory();
    private Queue queue = new Queue();
    private User assignedTo = new User();
    private TicketStatus status = new New();
    private LocalDateTime closedAt = LocalDateTime.now();

    public Ticket() {}

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRequested(User requestedBy) {
        this.requestedBy = requestedBy;
        this.requestedAt = LocalDateTime.now();
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public User getRequestedFor() {
        return requestedFor;
    }

    public void setRequestedFor(User requestedFor) {
        this.requestedFor = requestedFor;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public void setModified(User modifiedBy) {
        this.modifiedBy = modifiedBy;
        this.modifiedAt = LocalDateTime.now();
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Queue getQueue() {
        return queue;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        status.setTicket(this);
        this.status = status;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    public static class Builder {

        private Ticket ticket = new Ticket();

        public Builder title(String title) {
            this.ticket.setTitle(title);
            return this;
        }

        public Builder description(String description) {
            this.ticket.setDescription(description);
            return this;
        }

        public Builder requestedBy(User requestedBy) {
            this.ticket.setRequestedBy(requestedBy);
            return this;
        }

        public Builder requestedFor(User requestedFor) {
            this.ticket.setRequestedFor(requestedFor);
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.ticket.setRequestedAt(createdAt);
            return this;
        }

        public Builder modifiedBy(User modifiedBy) {
            this.ticket.setModifiedBy(modifiedBy);
            return this;
        }

        public Builder modifiedAt(LocalDateTime modifiedAt) {
            this.ticket.setModifiedAt(modifiedAt);
            return this;
        }

        public Builder category(Category category) {
            this.ticket.setCategory(category);
            return this;
        }

        public Builder subcategory(Subcategory subcategory) {
            this.ticket.setSubcategory(subcategory);
            return this;
        }

        public Builder queue(Queue queue) {
            this.ticket.queue = queue;
            return this;
        }

        public Builder assignedTo(User assignedTo) {
            this.ticket.setAssignedTo(assignedTo);
            return this;
        }

        public Builder status(TicketStatus status) {
            this.ticket.setStatus(status);
            return this;
        }

        public Builder closedAt(LocalDateTime closedAt) {
            this.ticket.setClosedAt(closedAt);
            return this;
        }

        public Ticket build() {
            return this.ticket;
        }
    }
}
