package com.codecool.fusy_qs.dto;

public class IndividualItemDto {
    private String name;
    private String description;
    private int price;

    public IndividualItemDto () {
    }

    public IndividualItemDto(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = Integer.parseInt(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
