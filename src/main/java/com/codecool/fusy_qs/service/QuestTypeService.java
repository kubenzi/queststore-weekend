package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.QuestType;

public interface QuestTypeService {
    void addQuestType(QuestType questType);
    QuestType findQuestTypeById(Long id);
}
