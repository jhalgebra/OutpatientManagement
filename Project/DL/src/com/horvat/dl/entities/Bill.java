package com.horvat.dl.entities;

import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bill implements IDisplayable {
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
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        return MessageFormat.format(
                "Bill issued on {0}, {1} payed by {2}",
                dateIssued,
                formatter.format(amount.doubleValue()),
                paymentType
        );
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Date issued", dateIssued);
                put("Payment type", paymentType);
                put("Amount", amount);
            }});
        }};
    }
}
