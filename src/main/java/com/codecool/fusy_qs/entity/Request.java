package com.codecool.fusy_qs.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;
    private String itemDescription;
    private Integer itemCost;

    @OneToOne
    private GroupClass group;

    @OneToOne
    private ItemType itemType;

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderColumn
    private List<RequestDetail> requestDetails = new ArrayList<>();

    public Request() {
    }

    public Request(Item item, Student student) {
        this.itemName = item.getItemName();
        this.itemDescription = item.getItemDescription();
        this.itemCost = item.getItemCost();
        this.itemType = item.getItemType();
        this.group = student.getGroups().get(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public GroupClass getGroup() {
        return group;
    }

    public void setGroup(GroupClass group) {
        this.group = group;
    }

    public List<RequestDetail> getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(List<RequestDetail> requestDetails) {
        this.requestDetails = requestDetails;
    }
}
