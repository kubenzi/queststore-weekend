package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends User{

    public Admin() {
    }

    public Admin(String firstName, String lastName, String email, String password, AccountType accountType) {
        super(firstName, lastName, email, password, accountType);
    }
}