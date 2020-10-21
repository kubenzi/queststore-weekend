package com.codecool.fusy_qs.entity;

import javax.persistence.*;

@Entity
public class RequestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestStudentId;

    @OneToOne
    Request request;

    @OneToOne
    Student student;

    Integer coolcoins;

    public RequestDetails() {
    }

    public RequestDetails(Request request, Student student, Integer coolcoins) {
        this.request = request;
        this.student = student;
        this.coolcoins = coolcoins;
    }

    public Long getRequestStudentId() {
        return requestStudentId;
    }

    public void setRequestStudentId(Long requestStudentId) {
        this.requestStudentId = requestStudentId;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
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
