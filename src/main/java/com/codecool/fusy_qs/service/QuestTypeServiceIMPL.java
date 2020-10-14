package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.QuestType;
import com.codecool.fusy_qs.repository.QuestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class QuestTypeServiceIMPL implements QuestTypeService {
    QuestTypeRepository questTypeRepository;

    @Autowired
    public QuestTypeServiceIMPL(QuestTypeRepository questTypeRepository) {
        this.questTypeRepository = questTypeRepository;
    }

    @Override
    public void addQuestType(QuestType questType) {
        questTypeRepository.save(questType);
    }

    public QuestType findQuestTypeById(Long id){
        return questTypeRepository.findById(id).orElse(null);
// dać orElse null albo optional?
    }

//    @PostConstruct
//    private void postConstruct(){
//        QuestType individual = new QuestType("individual");
//        QuestType group = new QuestType("group");
//        questTypeRepository.save(individual); questTypeRepository.save(group);
//    }
}
