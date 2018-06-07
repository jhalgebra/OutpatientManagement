package com.horvat.dl.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicDetails implements IDisplayable {
    private String name;
    private String oib;
    private String sex;
    private Date dateOfBirth;

    public BasicDetails(String name, String oib, String sex, Date dateOfBirth) {
        this.name = name;
        this.oib = oib;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getSex() {
        return sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "BasicDetails{" +
                "name='" + name + '\'' +
                ", oib='" + oib + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Name", name);
                put("OIB", oib);
                put("Sex", sex);
                put("Date of birth", dateOfBirth);
            }});
        }};
    }
}
