package com.codecool.fusy_qs.entity;

import javax.persistence.*;

@Embeddable
public class RequestDetail {

    @OneToOne
    Student student;

    Integer coolcoins;

    public RequestDetail() {
    }

    public RequestDetail(Student student, Integer coolcoins) {
        this.student = student;
        this.coolcoins = coolcoins;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getCoolcoins() {
        return coolcoins;
    }

    public void setCoolcoins(Integer coolcoins) {
        this.coolcoins = coolcoins;
    }
}
