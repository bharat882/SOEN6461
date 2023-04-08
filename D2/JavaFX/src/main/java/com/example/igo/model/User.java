package com.example.igo.model;

public class User {
    private String emailId;
    private String firstName;
    private String lastName;
    private String password;
    private int tickets;

    public User(){
        this.emailId = null;
        this.firstName = null;
        this.lastName = null;
        this.password = null;
        this.tickets = 0;
    }

    public User(String emailId, String firstName, String lastName, String password, int tickets) {
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.tickets = tickets;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}
