package com.codecool.fusy_qs.Level.Service;

import com.codecool.fusy_qs.Level.Model.Level;

import java.util.List;

public interface LevelService {
    Level getLevelByCcReq(Integer totalCoinsEarned);

    List<Level> getAllLevels();

    Level getLevelById(Integer idLevel);
}
