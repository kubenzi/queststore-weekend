package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Mentor extends User{

    public Mentor(){

    }

    public Mentor(String firstName, String lastName, String email, String password, AccountType accountType) {
        super(firstName, lastName, email, password, accountType);
    }

}

