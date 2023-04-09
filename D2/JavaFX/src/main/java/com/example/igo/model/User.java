package com.example.igo.model;

import java.util.Date;

public class User extends Role {
    private int userId;
    private String email;
    private String name;
    private String password;
    private Date dob;
    private String address;

    public User(){
        this.userId = 0;
        this.email = null;
        this.name = null;
        this.password = null;
        this.dob = null;
        this.address = null;
    }

    public User(int userId, String email, String name, String password, Date dob, String address) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.dob = dob;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
