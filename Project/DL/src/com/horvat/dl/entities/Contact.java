package com.horvat.dl.entities;

public class Contact {
    private String telephoneHome;
    private String telephoneWork;
    private String mobile;
    private String pager;
    private String fax;
    private String email;

    public Contact(String telephoneHome, String telephoneWork, String mobile, String pager, String fax, String email) {
        this.telephoneHome = telephoneHome;
        this.telephoneWork = telephoneWork;
        this.mobile = mobile;
        this.pager = pager;
        this.fax = fax;
        this.email = email;
    }

    public String getTelephoneHome() {
        return telephoneHome;
    }

    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    public String getTelephoneWork() {
        return telephoneWork;
    }

    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "telephoneHome='" + telephoneHome + '\'' +
                ", telephoneWork='" + telephoneWork + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pager='" + pager + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
