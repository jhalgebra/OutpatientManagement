package com.horvat.dl.entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProfessionDetails implements IDisplayable {
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

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Occupation", occupation);
                put("Gross annual income", grossAnnualIncome);
            }});
        }};
    }
}
