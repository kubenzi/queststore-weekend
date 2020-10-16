package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.ItemType;
import com.codecool.fusy_qs.repository.ItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {
    ItemTypeRepository itemTypeRepository;

    @Autowired
    public ItemTypeServiceImpl(ItemTypeRepository itemTypeRepository) {
        this.itemTypeRepository = itemTypeRepository;
    }

    @Override
    public ItemType findItemTypeById(Long id) {
        return itemTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void addItemType(ItemType itemType) {
        itemTypeRepository.save(itemType);
    }
}
