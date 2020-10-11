package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestType{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questTypeName;

    public QuestType() {
    }

    public QuestType(String questTypeName) {
        this.questTypeName = questTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestTypeName() {
        return questTypeName;
    }

    public void setQuestTypeName(String questTypeName) {
        this.questTypeName = questTypeName;
    }
}