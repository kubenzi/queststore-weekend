package com.codecool.fusy_qs.dto;

import com.codecool.fusy_qs.entity.AccountType;

public class StudentGroupDataDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int wallet;
    private int totalCoinsEarned;
    private AccountType accountType;
    private Long groupId;

    public StudentGroupDataDto(String firstName, String lastName, String email, String password, int wallet, int totalCoinsEarned, AccountType accountType, Long groupId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
        this.totalCoinsEarned = totalCoinsEarned;
        this.accountType = accountType;
        this.groupId = groupId;
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

    public StudentGroupDataDto() {
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }


}
