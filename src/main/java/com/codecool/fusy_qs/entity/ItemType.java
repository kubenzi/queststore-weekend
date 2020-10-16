package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemType {

    @Id
    @GeneratedValue
    private int itemTypeId;

    private String itemTypeName;

    public ItemType() {
    }

    public ItemType(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }
}

