package com.horvat.dl.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContactOfNextOfKin implements IDisplayable {
    private String name;
    private String contactAddress;
    private Contact contact;

    public ContactOfNextOfKin(String name, String contactAddress, Contact contact) {
        this.name = name;
        this.contactAddress = contactAddress;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ContactOfNextOfKin{" +
                "name='" + name + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", contact=" + contact +
                '}';
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Name", name);
                put("Contact address", contactAddress);
            }});

            put("Contact", contact.getDisplayDataGroups().get(NON_GROUPED_NAME));
        }};
    }
}
