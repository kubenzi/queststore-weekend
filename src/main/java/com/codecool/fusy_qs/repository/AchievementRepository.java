package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Achievement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AchievementRepository extends CrudRepository<Achievement, Long> {

    @Query(value = "SELECT * FROM transaction_details WHERE student_user_id = ?1", nativeQuery = true)
    List<Achievement> getAllAchievementsByStudentId(Long studentId);
}

