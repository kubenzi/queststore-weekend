package com.codecool.fusy_qs.entity;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class Transaction {

    @OneToOne
    private Item item;

    public Transaction() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
