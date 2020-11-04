package com.codecool.fusy_qs.dto;

public class GroupPurchaseDto {

    private int coolcoins;

    public GroupPurchaseDto() {
    }

    public GroupPurchaseDto(int coolcoins) {
        this.coolcoins = coolcoins;
    }

    public int getCoolcoins() {
        return coolcoins;
    }

    public void setCoolcoins(int coolcoins) {
        this.coolcoins = coolcoins;
    }
}
