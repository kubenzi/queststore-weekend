package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemTypeId;

    private String itemTypeName;

    public ItemType() {
    }

    public boolean equals(Object object) {
        ItemType itemType = (ItemType) object;

        if (itemTypeId != itemType.itemTypeId)
            return false;

        return true;
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

