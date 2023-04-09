package com.example.igo.model;

import java.util.Date;

public class Transactions {
    private int transactionId;
    private int userId;
    private double amount;
    private Date transactionDate;
    private String paymentMode;

    Transactions(){
        this.transactionId = 0;
        this.userId = 0;
        this.amount = 0.0d;
        this.transactionDate = null;
        this.paymentMode = null;
    }

    public Transactions(int transactionId, int userId, double amount, Date transactionDate, String paymentMode) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.paymentMode = paymentMode;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", paymentMode='" + paymentMode + '\'' +
                '}';
    }
}
