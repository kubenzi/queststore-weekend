package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestType{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questTypeId;

    private String questTypeName;

    public QuestType() {
    }

    public boolean equals(Object object) {
        QuestType questType = (QuestType) object;

        if (questTypeId != questType.questTypeId)
            return false;

        return true;
    }

    public QuestType(String questTypeName) {
        this.questTypeName = questTypeName;
    }

    public Long getQuestTypeId() {
        return questTypeId;
    }

    public void setQuestTypeId(Long questTypeId) {
        this.questTypeId = questTypeId;
    }

    public String getQuestTypeName() {
        return questTypeName;
    }

    public void setQuestTypeName(String questTypeName) {
        this.questTypeName = questTypeName;
    }
}