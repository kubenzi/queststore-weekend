package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Achievement;


import java.util.List;

public interface AchievementService {
    List<Achievement> getAllAchievementsByStudentIdAndByQuestType(Long studentId, Long QuestTypeId);
    Integer calculateTotalValueOfAchievementsList(List<Achievement> achievements);
    void delete(Achievement achievement);
}
