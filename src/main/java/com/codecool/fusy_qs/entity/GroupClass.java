package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "GROUP_CLASS")
public class GroupClass {

    @Id
    @GeneratedValue
    private Long groupId;

    private String groupName;

    @ManyToMany
    private List<Student> users= new ArrayList<>();

    @Embedded
    private Class groupClass;

    public GroupClass() {
    }

    public GroupClass(String groupName, Class groupClass) {
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

    public List<Student> getUsers() {
        return users;
    }

    public void setUsers(List<Student> users) {
        this.users = users;
    }

    public Class getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(Class groupClass) {
        this.groupClass = groupClass;
    }
}
