package com.codecool.fusy_qs;

public enum Order {
    FIRST_ATTRIBUTE(1);

    private final Integer value;

    Order(final Integer newValue) {
        value = newValue;
    }

    public Integer getValue(){
        return value;
    }
}
