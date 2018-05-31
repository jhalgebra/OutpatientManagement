package com.horvat.dl.entities;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;

public class Bill {
    private Integer id;
    private Date dateIssued;
    private String paymentType;
    private BigDecimal amount;

    public Bill() { }

    public Bill(Integer id, Date dateIssued, String paymentType, BigDecimal amount) {
        this.id = id;
        this.dateIssued = dateIssued;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Bill issued on {0}, {1} payed by {2}",
                dateIssued,
                amount,
                paymentType
        );
    }
}
