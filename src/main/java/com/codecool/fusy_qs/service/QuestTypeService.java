package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.QuestType;
import com.codecool.fusy_qs.entity.Student;

import java.util.List;

public interface QuestTypeService {
    void addQuestType(QuestType questType);
    QuestType findQuestTypeById(Long id);
    List<QuestType> findAllQuestTypes();
}
