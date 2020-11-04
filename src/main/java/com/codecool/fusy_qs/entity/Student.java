package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends User {
    private int wallet;
    private int totalCoinsEarned;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_achievement_list", inverseJoinColumns = @JoinColumn(name = "achievement_id"))
    private List<Achievement> achievementList;

    @OneToMany
    @JoinTable(name = "student_transaction_details", inverseJoinColumns = @JoinColumn(name = "transaction_id"))
    private List<Transaction> transactionList;

    public Student() {
    }

    public Student(String firstName,
                   String lastName,
                   String email,
                   String password,
                   AccountType accountType,
                   int wallet,
                   int totalCoinsEarned) {
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
