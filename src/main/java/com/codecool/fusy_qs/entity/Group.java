package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    private Long groupId;

    private String groupName;

    @ManyToMany
    private List<User> users;

    @Embedded
    private Class groupClass;

    public Group() {
    }

    public Group(String groupName, Class groupClass) {
        this.groupName = groupName;
        this.groupClass = groupClass;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Class getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(Class groupClass) {
        this.groupClass = groupClass;
    }
}
