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

    private boolean isUsed;

    public Transaction() {
    }

    public Transaction(String itemName, String itemDescription, Integer itemCost, ItemType itemType, boolean isUsed) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCost = itemCost;
        this.itemType = itemType;
        this.isUsed = isUsed;
    }

    private boolean itemTypeValidator(Item item){
        return item.getItemType().getItemTypeName().equals("group");
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

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
