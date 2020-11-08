package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Student extends User {
    private Integer wallet;
    private Integer totalCoinsEarned;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_achievement_list", inverseJoinColumns = @JoinColumn(name = "achievement_id"))
    private List<Achievement> achievementList;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_transaction_details", inverseJoinColumns = @JoinColumn(name = "transaction_id"))
    private List<Transaction> transactionList;

    public Student() {
    }

    public Student(String firstName,
                   String lastName,
                   String email,
                   String password,
                   AccountType accountType,
                   Integer wallet,
                   Integer totalCoinsEarned) {
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
