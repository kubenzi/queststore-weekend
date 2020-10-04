package com.codecool.fusy_qs.Quest.DAO;

import com.codecool.fusy_qs.Quest.Model.Quest;

import java.util.List;

public interface QuestDao {
    Quest getQuestByID(String questID);
    List<Quest> getAllQuests();
    List<Quest> getIndividualQuests();
    List<Quest> getGroupQuests();
    int removeQuestByID(String questID);
    void addNewQuest(Quest newQuest);
    void updateQuest(String questID, int newValue, String newDescription);
}
