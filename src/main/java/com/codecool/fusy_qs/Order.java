package com.codecool.fusy_qs;

public enum Order {
    FIRST_ATTRIBUTE(1),
    SECOND_ATTRIBUTE(2),
    THIRD_ATTRIBUTE(3),
    FOURTH_ATTRIBUTE(4);

    private final Integer value;

    Order(final Integer newValue) {
        value = newValue;
    }

    public Integer getValue(){
        return value;
    }
}
