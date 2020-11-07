package com.codecool.fusy_qs.dto;

public class RequestDetailsDto {
    boolean isWithdrawed;
    int coolcoins;

    public RequestDetailsDto() {
    }

    public RequestDetailsDto(boolean isWithdrawed, int coolcoins) {
        this.isWithdrawed = isWithdrawed;
        this.coolcoins = coolcoins;
    }

    public boolean getIsWithdrawed() {
        return isWithdrawed;
    }

    public void setIsWithdrawed(boolean withdrawed) {
        isWithdrawed = withdrawed;
    }

    public int getCoolcoins() {
        return coolcoins;
    }

    public void setCoolcoins(int coolcoins) {
        this.coolcoins = coolcoins;
    }
}
