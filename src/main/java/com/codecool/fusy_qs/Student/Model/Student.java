package com.codecool.fusy_qs.Student.Model;

import com.codecool.fusy_qs.Group.Group;

public class Student {
    private String id;
    private Integer accountType;
    private String firstName;
    private String lastName;
    private String email;
    private Group group;

    public Student(String id, Integer accountType, String firstName, String lastName, String email, Group group) {
        this.id = id;
        this.accountType = accountType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", accountType=" + accountType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}



