package com.codecool.fusy_qs.Quest.Service;

import com.codecool.fusy_qs.Quest.DAO.QuestDao;
import com.codecool.fusy_qs.Quest.Model.Quest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceIMPL implements QuestService {
    private QuestDao questDao;

    public QuestServiceIMPL()
    {
        this.questDao = questDao;
    }

    @Override
    public Quest getQuestByID(String questID)
    {
        return questDao.getQuestByID(questID);
    }

    @Override
    public List<Quest> getAllQuests() {
        return questDao.getAllQuests();
    }

    @Override
    public List<Quest> getIndividualQuests() {
        return questDao.getIndividualQuests();
    }

    @Override
    public List<Quest> getGroupQuests() {
        return questDao.getGroupQuests();
    }

    @Override
    public void removeQuestByID(String questID) {
        questDao.removeQuestByID(questID);
    }

    @Override
    public void addNewQuest(Quest newQuest) {
        questDao.addNewQuest(newQuest);
    }

    @Override
    public void updateQuest(String questID, int newValue, String newDescription) {
        questDao.updateQuest(questID, newValue, newDescription);
    }
}
