package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.QuestType;
import com.codecool.fusy_qs.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestTypeRepository  extends CrudRepository<QuestType, Long> {

    @Query(value = "SELECT * FROM quest_type", nativeQuery = true)
    List<QuestType> findAllQuestTypes();
}
