package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Quest;
import com.codecool.fusy_qs.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceImpl {
    QuestRepository questRepository;

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
}
