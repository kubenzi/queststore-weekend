package com.codecool.fusy_qs.entity;

import javax.persistence.*;

@Entity
public class Achievement {

    @Id
    @SequenceGenerator(name= "achievement_id_gen", initialValue = 20, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "achievement_id_gen")
    private Long id;

    @OneToOne
    private QuestType questType;

    private String questDescription;

    private int questValue;

    public Achievement() {
    }

    public Achievement(Quest quest,
                       Student student) {
        this.questType = quest.getQuestType();
        this.questDescription = quest.getQuestDescription();
        this.questValue = quest.getQuestValue();
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
        return questType.getQuestTypeName() + " - " + questDescription + " - " + questValue;
    }
}
