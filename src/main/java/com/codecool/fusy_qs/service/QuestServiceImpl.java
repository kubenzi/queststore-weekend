package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Quest;
import com.codecool.fusy_qs.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    QuestRepository questRepository;

    @Autowired
    public QuestServiceImpl(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public QuestServiceImpl() {
    }

    public List<Quest> getAllQuests() {
        return questRepository.getAllQuests();
    }

    public List<Quest> getAllGroupQuests() {
        return questRepository.getAllGroupQuests();
    }

    public List<Quest> getAllIndividualQuests() {
        return questRepository.getAllIndividualQuests();
    }

    @Override
    public void addQuest(Quest quest) {
        questRepository.save(quest);
    }

    @Override
    public void saveQuest(Quest quest) {
        questRepository.save(quest);
    }

    @Override
    public Quest getQuestById(Long id) {
        return questRepository.findQuestById(id);
    }
}
