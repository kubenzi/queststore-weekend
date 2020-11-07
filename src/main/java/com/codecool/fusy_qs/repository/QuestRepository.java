package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Quest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepository extends CrudRepository<Quest, Long> {

    @Query(value = "select * from QUEST", nativeQuery = true)
    List<Quest> getAllQuests();

    @Query(value = "select u from Quest u where u.questType.questTypeName = 'group'")
    List<Quest> getAllGroupQuests();

    @Query(value = "select u from Quest u where u.questType.questTypeName = 'individual'")
    List<Quest> getAllIndividualQuests();

    Quest findQuestById(Long id);

}
