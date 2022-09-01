package com.art.login.dto;

import java.sql.Date;

public class User {

    private String name;
    private String email;
    private String password;
    private String contact;
    private String country;
    private Date dob;
    private String newPassword;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    // to reset password
    public User(String email, String password, String newPassword) {
        super();
        this.email = email;
        this.password = password;
        this.newPassword = newPassword;
    }

    // to verify
    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    // for register
    public User(String name, String email, String password, String contact, String country, Date dob) {
        super();
        this.email = email;
        this.password = password;
        this.country = country;
        this.name = name;
        this.contact = contact;
        this.dob = dob;
    }

    // to display
    public User(String name, String email, String contact, String country, Date dob) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
        this.contact = contact;
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", country='" + country + '\'' +
                ", dob=" + dob +
                '}';
    }
}
