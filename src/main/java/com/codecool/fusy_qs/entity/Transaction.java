package com.codecool.fusy_qs.entity;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Transaction {

    private String itemName;

    private String itemDescription;

    private Integer itemCost;

    @OneToOne
    private ItemType itemType;

    public Transaction() {
    }

    public Transaction(Item item) {
        this.itemName = item.getItemName();
        this.itemDescription = item.getItemDescription();
        this.itemCost = item.getItemCost();
        this.itemType = item.getItemType();
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

    public Integer getItemCost() {
        return itemCost;
    }

    public void setItemCost(Integer itemCost) {
        this.itemCost = itemCost;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
