package com.codecool.fusy_qs.dto;

import com.codecool.fusy_qs.entity.QuestType;

public class QuestDataDto {

    private QuestType questType;
    private String questDescription;
    private int questValue;

    public QuestDataDto(QuestType questType, String questDescription, int questValue) {
        this.questType = questType;
        this.questDescription = questDescription;
        this.questValue = questValue;
    }

    public QuestDataDto() {
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
}
