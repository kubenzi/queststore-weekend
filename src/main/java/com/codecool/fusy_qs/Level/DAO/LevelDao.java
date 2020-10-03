package com.codecool.fusy_qs.Level.DAO;

import com.codecool.fusy_qs.Level.Model.Level;

import java.util.List;

public interface LevelDao {
    Level getLevelCcReq(Integer totalCoinsEarned);

    List<Level> getAllLevels();

    Level getLevelById(Integer levelId);

    void editLevel(Level level);

    void deleteLevelById(Integer idLevel);
}


