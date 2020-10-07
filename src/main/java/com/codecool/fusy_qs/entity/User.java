package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USER_DATA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToOne
    private AccountType accountType;

    @OneToMany
    private List<Group> groups;

    public User() {
    }

    public User(String firstName,
                String lastName,
                String email,
                String password,
                AccountType accountType, List<Group> groups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.groups = groups;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
