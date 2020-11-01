package com.codecool.fusy_qs.entity;

import javax.persistence.*;

@Embeddable
public class Achievement {

    @OneToOne
    private QuestType questType;

    private String questDescription;

    private int questValue;

    public Achievement() {
    }

    public Achievement(Quest quest) {
        this.questType = quest.getQuestType();
        this.questDescription = quest.getQuestDescription();
        this.questValue = quest.getQuestValue();
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
        return questType.getQuestTypeName() + " - " + questDescription + " - " + questValue;
    }
}
