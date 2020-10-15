package com.codecool.fusy_qs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long itemId;

    private int itemTypeId;

    private String itemName;

    private String itemDescription;

    private int itemCost;

    @OneToOne
    private ItemType itemType;

    public Item() {
    }

    public Item(Long itemId, int itemTypeId, String itemName, String itemDescription, int itemCost, ItemType itemType) {
        this.itemId = itemId;
        this.itemTypeId = itemTypeId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCost = itemCost;
        this.itemType = itemType;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemCost() {
        return itemCost;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
