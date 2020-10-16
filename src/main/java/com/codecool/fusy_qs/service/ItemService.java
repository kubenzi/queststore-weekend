package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    List<Item> getAllIndividualItems();

    List<Item> getAllGroupItems();

    void addItem(Item item);
}
