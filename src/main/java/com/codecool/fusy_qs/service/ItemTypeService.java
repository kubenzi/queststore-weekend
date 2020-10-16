package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.ItemType;

public interface ItemTypeService {

    ItemType findItemTypeById(Long id);

    void addItemType(ItemType itemType);
}
