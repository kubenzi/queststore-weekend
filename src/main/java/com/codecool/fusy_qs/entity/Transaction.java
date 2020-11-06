package com.codecool.fusy_qs.entity;

import javax.persistence.*;

@Entity(name = "transaction_details")
public class Transaction {

    @Id
    @SequenceGenerator(name= "transaction_id_gen", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_gen")
    private Long id;

    private String itemName;

    private String itemDescription;

    private Integer itemCost;

    @OneToOne
    private ItemType itemType;

    private boolean isUsed;

    @ManyToOne
    private Student student;

    public Transaction() {
    }

    public Transaction(String itemName,
                       String itemDescription,
                       Integer itemCost,
                       ItemType itemType,
                       boolean isUsed,
                       Student student) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCost = itemCost;
        this.itemType = itemType;
        this.isUsed = isUsed;
        this.student = student;
    }

    public Transaction(String itemName,
                       String itemDescription,
                       Integer itemCost,
                       boolean isUsed,
                       Student student) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCost = itemCost;
        this.isUsed = isUsed;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean used) {
        isUsed = used;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
