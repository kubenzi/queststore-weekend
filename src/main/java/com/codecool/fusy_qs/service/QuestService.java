package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Quest;

import java.util.List;

public interface QuestService {
    List<Quest> getAllQuests();
    List<Quest> getAllGroupQuests();
    List<Quest> getAllIndividualQuests();
    Quest getQuestById(Long id);
    void addQuest(Quest quest);
    void saveQuest(Quest quest);
    void deleteQuest(Quest quest);

}
