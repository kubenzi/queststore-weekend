package com.codecool.fusy_qs.Level.Model;

public class Level {
    private Integer levelId;
    private String levelName;
    private Integer ccolcoinsRequired;

    public Level(Integer levelId, String levelName, Integer ccolcoinsRequired) {
        this.levelId = levelId;
        this.levelName = levelName;
        this.ccolcoinsRequired = ccolcoinsRequired;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getCcolcoinsRequired() {
        return ccolcoinsRequired;
    }

    public void setCcolcoinsRequired(Integer ccolcoinsRequired) {
        this.ccolcoinsRequired = ccolcoinsRequired;
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", ccolcoinsRequired=" + ccolcoinsRequired +
                '}';
    }
}
