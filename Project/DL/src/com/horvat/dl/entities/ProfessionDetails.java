package com.horvat.dl.entities;

import java.math.BigDecimal;

public class ProfessionDetails {
    private String occupation;
    private BigDecimal grossAnnualIncome;

    public ProfessionDetails(String occupation, BigDecimal grossAnnualIncome) {
        this.occupation = occupation;
        this.grossAnnualIncome = grossAnnualIncome;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public BigDecimal getGrossAnnualIncome() {
        return grossAnnualIncome;
    }

    public void setGrossAnnualIncome(BigDecimal grossAnnualIncome) {
        this.grossAnnualIncome = grossAnnualIncome;
    }

    @Override
    public String toString() {
        return "ProfessionDetails{" +
                "occupation='" + occupation + '\'' +
                ", grossAnnualIncome=" + grossAnnualIncome +
                '}';
    }
}
