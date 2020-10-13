package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long levelId;
    private String levelName;
    private Integer coolcoinsRequired;
    private String iconName;

    public Level() {
    }

    public Level(String levelName, Integer coolcoinsRequired, String iconName) {
        this.levelName = levelName;
        this.coolcoinsRequired = coolcoinsRequired;
        this.iconName = iconName;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getCoolcoinsRequired() {
        return coolcoinsRequired;
    }

    public void setCoolcoinsRequired(Integer coolcoinsRequired) {
        this.coolcoinsRequired = coolcoinsRequired;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
