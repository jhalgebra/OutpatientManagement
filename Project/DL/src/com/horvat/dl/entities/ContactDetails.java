package com.horvat.dl.entities;

public class ContactDetails {
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
}
