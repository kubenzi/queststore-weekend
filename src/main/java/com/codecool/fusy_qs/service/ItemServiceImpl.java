package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Item;
import com.codecool.fusy_qs.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    @Override
    public List<Item> getAllIndividualItems() {
        return itemRepository.getAllIndividualItems();
    }

    @Override
    public List<Item> getAllGroupItems() {
        return itemRepository.getAllGroupItems();
    }

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }
}
