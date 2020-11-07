package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Achievement;
import com.codecool.fusy_qs.repository.AchievementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    AchievementRepository achievementRepository;

    public AchievementServiceImpl() {
    }

    @Override
    public Integer calculateTotalValueOfAchievementsList(List<Achievement> achievements) {
        Integer totalValue = 0;

        for (Achievement achievement : achievements) {
            totalValue += achievement.getQuestValue();
        }

        return totalValue;
    }

    @Override
    public void delete(Achievement achievement) {
        achievementRepository.delete(achievement);
    }
}
