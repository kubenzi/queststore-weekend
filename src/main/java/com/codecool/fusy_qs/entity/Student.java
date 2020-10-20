package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Student extends User {

    private int wallet;

    private int totalCoinsEarned;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String password, AccountType accountType, int wallet, int totalCoinsEarned) {
        super(firstName, lastName, email, password, accountType);
        this.wallet = wallet;
        this.totalCoinsEarned = totalCoinsEarned;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getTotalCoinsEarned() {
        return totalCoinsEarned;
    }

    public void setTotalCoinsEarned(int totalCoinsEarned) {
        this.totalCoinsEarned = totalCoinsEarned;
    }

}