package com.example.igo.model;

public class Transactions {
    private String userId;
    private String id;
    private float amount;
    private String date;

    Transactions(){
        this.userId = null;
        this.id = null;
        this.amount = 0.0f;
        this.date = null;
    }

    public Transactions(String userId, String id, float amount, String date) {
        this.userId = userId;
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
