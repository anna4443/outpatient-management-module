package com.as.model;

import java.util.Date;

public class Bill {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateIssuing() {
        return dateIssuing;
    }

    public void setDateIssuing(Date dateIssuing) {
        this.dateIssuing = dateIssuing;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private int id;
    private Date dateIssuing;

   public String getPaymentType() {
        return paymentType;
 }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

  private String paymentType;
    private int paymentTypeID;

    public int getPaymentTypeID() {
        return paymentTypeID;
    }

    public void setPaymentTypeID(int paymentTypeID) {
        this.paymentTypeID = paymentTypeID;
    }

    private int patientId;
    private double amount;
}
