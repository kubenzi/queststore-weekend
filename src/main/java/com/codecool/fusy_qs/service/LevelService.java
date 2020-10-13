package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Level;

import java.util.List;

public interface LevelService {
    List<Level> getAllLevels();
    Level getLevelByCcRequired(Integer coolcoinsRequired);
    Level getLevelById(Long levelId);
    void saveLevel(Level level);
}
