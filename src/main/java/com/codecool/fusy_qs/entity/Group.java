package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    private String groupName;

    @Embedded
    private Class groupClass;

    public Group() {
    }

    public Group(String groupName,
                 Class groupClass,
                 List<User> user) {
        this.groupName = groupName;
        this.groupClass = groupClass;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Class getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(Class groupClass) {
        this.groupClass = groupClass;
    }
}
