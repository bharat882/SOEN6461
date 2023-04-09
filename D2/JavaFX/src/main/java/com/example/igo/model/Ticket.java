package com.example.igo.model;

import java.util.Date;

public class Ticket {
    private int ticketId;
    private Date ticketDate;
    private String description;
    private String ticketType;
    private int customerId;

    Ticket(){
        this.ticketId = 0;
        this.ticketDate = null;
        this.description = null;
        this.ticketType = null;
        this.customerId = 0;
    }

    public Ticket(int ticketId, Date ticketDate, String description, String ticketType, int customerId) {
        this.ticketId = ticketId;
        this.ticketDate = ticketDate;
        this.description = description;
        this.ticketType = ticketType;
        this.customerId = customerId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", ticketDate=" + ticketDate +
                ", description='" + description + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
