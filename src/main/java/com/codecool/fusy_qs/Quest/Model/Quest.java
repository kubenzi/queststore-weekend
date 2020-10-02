package com.codecool.fusy_qs.Quest.Model;

public class Quest {
    private String questID;
    private int questTypeID;
    private String questTypeName;
    private String questDescription;
    private int questValue;

    public Quest(String questID, int questTypeID, String questType, String questDescription, int questValue) {
        this.questID = questID;
        this.questTypeID = questTypeID;
        this.questTypeName = questType;
        this.questDescription = questDescription;
        this.questValue = questValue;
    }

    public String getQuestID() {
        return questID;
    }

    public void setQuestID(String questID) {
        this.questID = questID;
    }

    public int getQuestTypeID() {
        return questTypeID;
    }

    public void setQuestTypeID(int questTypeID) {
        this.questTypeID = questTypeID;
    }

    public String getQuestType() {
        return questTypeName;
    }

    public void setQuestType(String questType) {
        this.questTypeName = questType;
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
        return "Quest {" +
                "type = " + questTypeName +
                "ID = " + questDescription +
                "value = " + questValue;
    }
}
