package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "USER_DATA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(name= "id_gen", initialValue = 10, allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    private Long  userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToOne
    private AccountType accountType;

//    @ManyToMany(mappedBy = "user")
//    private List<Group> groups;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_Group",
            joinColumns = {@JoinColumn(name= "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )

    private List<GroupClass> groups = new ArrayList<>();


    public User() {
    }

    public User(String firstName,
                String lastName,
                String email,
                String password,
                AccountType accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.accountType = accountType;

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public List<GroupClass> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupClass> groups) {
        this.groups = groups;
    }
}
