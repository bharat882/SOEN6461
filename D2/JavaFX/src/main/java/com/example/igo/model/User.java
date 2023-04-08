package com.example.igo.model;

import java.util.Date;

public class User extends Role {
    private int userId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private int tickets;
    private Date dob;
    private String address;

    public User(){
        this.userId = 0;
        this.email = null;
        this.firstName = null;
        this.lastName = null;
        this.password = null;
        this.tickets = 0;
        this.dob = null;
        this.address = null;
    }

    public User(int userId, String email, String firstName, String lastName, String password, int tickets, Date dob, String address) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.tickets = tickets;
        this.dob = dob;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
