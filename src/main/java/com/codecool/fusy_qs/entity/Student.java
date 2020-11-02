package com.codecool.fusy_qs.entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Student extends User {

    private Integer wallet;

    private Integer totalCoinsEarned;

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderColumn
    private List<Achievement> achievementList = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderColumn
    private List<Transaction> transactionList = new ArrayList<>();


    public Student() {
    }

    public Student(String firstName, String lastName, String email, String password, AccountType accountType, Integer wallet, Integer totalCoinsEarned) {
        super(firstName, lastName, email, password, accountType);
        this.wallet = wallet;
        this.totalCoinsEarned = totalCoinsEarned;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }

    public Integer getTotalCoinsEarned() {
        return totalCoinsEarned;
    }

    public void setTotalCoinsEarned(Integer totalCoinsEarned) {
        this.totalCoinsEarned = totalCoinsEarned;
    }

    public List<Achievement> getAchievementList() {
        return achievementList;
    }

    public void setAchievementList(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
