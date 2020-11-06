package com.codecool.fusy_qs.dto;

public class ItemStatusDto {
    private Long transactionId;

    public ItemStatusDto() {
    }

    public ItemStatusDto(Long transactionId) {
        this.transactionId = transactionId;

    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
