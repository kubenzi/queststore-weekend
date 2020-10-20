package com.codecool.fusy_qs.entity;

import javax.persistence.*;

@Embeddable
public class Achievement {

    @OneToOne
    private Quest quest;

    public Achievement() {
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

}
