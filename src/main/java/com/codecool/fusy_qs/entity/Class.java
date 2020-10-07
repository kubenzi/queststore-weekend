package com.codecool.fusy_qs.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Class {

    private String className;

    public Class() {
    }

    public Class(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String name) {
        this.className = name;
    }
}
