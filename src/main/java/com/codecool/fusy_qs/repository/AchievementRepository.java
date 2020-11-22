package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Achievement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AchievementRepository extends CrudRepository<Achievement, Long> {

    @Query(value = "SELECT * FROM achievement WHERE student_user_id = ?1 AND quest_type_quest_type_id = ?2",
            nativeQuery = true)
    List<Achievement> getAllAchievementsByStudentIdAndByQuestType(Long studentId, Long QuestTypeId);
}