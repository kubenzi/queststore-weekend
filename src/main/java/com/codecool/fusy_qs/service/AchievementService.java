package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Achievement;

import java.util.List;

public interface AchievementService {
    Integer calculateTotalValueOfAchievementsList(List<Achievement> achievements);

    void delete(Achievement achievement);
}
