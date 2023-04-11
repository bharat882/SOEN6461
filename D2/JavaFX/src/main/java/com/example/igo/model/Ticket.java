package com.example.igo.model;

import java.util.Date;

public class Ticket {
    private int ticketId;
    private Date ticketDate;
    private String description;
    private String ticketType;
    private int customerId;
    private String validity;

    Ticket(){
        this.ticketId = 0;
        this.ticketDate = null;
        this.description = null;
        this.ticketType = null;
        this.customerId = 0;
        this.validity = null;
    }

    public Ticket(int ticketId, Date ticketDate, String description, String ticketType, int customerId, String validity) {
        this.ticketId = ticketId;
        this.ticketDate = ticketDate;
        this.description = description;
        this.ticketType = ticketType;
        this.customerId = customerId;
        this.validity = validity;
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

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
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
