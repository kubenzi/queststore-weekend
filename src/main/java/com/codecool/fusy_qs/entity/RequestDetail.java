package com.codecool.fusy_qs.entity;

import javax.persistence.*;

@Entity
public class RequestDetail {

    @Id
    @SequenceGenerator(name= "request_detail_id_gen", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_detail_id_gen")
    private Long id;

    @OneToOne
    Student student;

    Integer coolcoins;

    @ManyToOne
    private Request request;

    public RequestDetail() {
    }

    public RequestDetail(Student student,
                         Integer coolcoins,
                         Request request) {
        this.student = student;
        this.coolcoins = coolcoins;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
