package com.horvat.dal.entities;

import com.lib.dal.entities.IDatabaseObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.Function;

public class Bill implements IDatabaseObject<Bill> {
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
    public Function<Object[], Bill> getConverter(Object... objects) {
        return data -> new Bill(
                (Integer)data[0],
                (Date)data[1],
                (String)data[2],
                (BigDecimal)data[3]
        );
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", dateIssued=" + dateIssued +
                ", paymentType='" + paymentType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
