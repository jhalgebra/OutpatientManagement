package com.horvat.dl.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContactDetails implements IDisplayable {
    private String presentAddress;
    private String permanentAddress;
    private Contact contact;

    public ContactDetails(String presentAddress, String permanentAddress, Contact contact) {
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.contact = contact;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "presentAddress='" + presentAddress + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", contact=" + contact +
                '}';
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            HashMap<String, Object> map = new HashMap<String, Object>() {{
                put("Present address", presentAddress);
                put("Permanent address", permanentAddress);
            }};

            map.putAll(contact.getDisplayDataGroups().get(NON_GROUPED_NAME));

            put(NON_GROUPED_NAME, map);
        }};
    }

    @Override
    public Map<String, List<? extends IDisplayable>> getInnerData() {
        return null;
    }
}
