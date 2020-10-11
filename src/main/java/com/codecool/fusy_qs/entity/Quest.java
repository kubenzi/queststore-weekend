package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Quest {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private QuestType questType;

    private String questDescription;

    private int questValue;

    public Quest() {
    }

    public Quest(QuestType questType,
                 String questDescription,
                 int questValue) {
        this.questType = questType;
        this.questDescription = questDescription;
        this.questValue = questValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuestType getQuestType() {
        return questType;
    }

    public void setQuestType(QuestType questType) {
        this.questType = questType;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }

    public int getQuestValue() {
        return questValue;
    }

    public void setQuestValue(int questValue) {
        this.questValue = questValue;
    }

    @Override
    public String toString() {
        return id + '.' + questDescription;
    }
}
