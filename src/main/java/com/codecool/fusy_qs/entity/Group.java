package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    private String groupName;

    @ManyToOne
    private User user;

    @Embedded
    private Class groupClass;

    public Group() {
    }

    public Group(String groupName, Class groupClass) {
        this.groupName = groupName;
        this.groupClass = groupClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Class getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(Class groupClass) {
        this.groupClass = groupClass;
    }
}
