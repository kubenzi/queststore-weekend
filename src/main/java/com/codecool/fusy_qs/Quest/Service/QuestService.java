package com.codecool.fusy_qs.Quest.Service;

import com.codecool.fusy_qs.Quest.Model.Quest;

import java.util.List;

public interface QuestService {
    Quest getQuestByID(String questID);
    List<Quest> getAllQuests();
    List<Quest> getIndividualQuests();
    List<Quest> getGroupQuests();
    void removeQuestByID(String questID);
    void addNewQuest(Quest newQuest);
    void updateQuest(String questID, int newValue, String newDescription);
}
