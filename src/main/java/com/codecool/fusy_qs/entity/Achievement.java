package com.codecool.fusy_qs.entity;

import javax.persistence.*;

@Entity
public class Achievement {

    @Id
    @GeneratedValue
    private Long achievementId;

    @OneToOne
    private Quest quest;

    @OneToOne
    private Student student;

    public Achievement() {
    }

    public Achievement(Quest quest, Student student) {
        this.quest = quest;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

}
