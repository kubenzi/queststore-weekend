package com.codecool.fusy_qs.Mentor.Model;


import com.codecool.fusy_qs.Group.Model.Group;

import java.util.ArrayList;

public class Mentor {
    private String id;
    private Integer accountType;
    private String firstName;
    private String lastName;
    private String email;

    private String classes = "Web";

    public Mentor(String id, Integer accountType, String firstName, String lastName, String email) {
        this.id = id;
        this.accountType = accountType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getId() {
        return id;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }



    public String getClasses() {return classes;}
    @Override
    public String toString() {
        return "Mentor{" +
                "id='" + id + '\'' +
                ", accountType=" + accountType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
