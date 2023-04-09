package com.example.igo.model;

public class Fare {
    private int fareId;
    private double fareAmount;
    private String fareTitle;
    private String fareDescription;
    private String fareType;

    Fare(){
        this.fareId = 0;
        this.fareAmount = 0.0d;
        this.fareTitle = null;
        this.fareDescription = null;
        this.fareType = null;
    }

    public Fare(int fareId, double fareAmount, String fareTitle, String fareDescription, String fareType) {
        this.fareId = fareId;
        this.fareAmount = fareAmount;
        this.fareTitle = fareTitle;
        this.fareDescription = fareDescription;
        this.fareType = fareType;
    }

    public int getFareId() {
        return fareId;
    }

    public void setFareId(int fareId) {
        this.fareId = fareId;
    }

    public String getFareTitle() {
        return fareTitle;
    }

    public void setFareTitle(String fareTitle) {
        this.fareTitle = fareTitle;
    }

    public String getFareDescription() {
        return fareDescription;
    }

    public void setFareDescription(String fareDescription) {
        this.fareDescription = fareDescription;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public double getFareAmount() {
        return fareAmount;
    }

    public void setFareAmount(double fareAmount) {
        this.fareAmount = fareAmount;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "fareId=" + fareId +
                ", fareAmount=" + fareAmount +
                ", fareTitle='" + fareTitle + '\'' +
                ", fareDescription='" + fareDescription + '\'' +
                ", fareType='" + fareType + '\'' +
                '}';
    }
}
