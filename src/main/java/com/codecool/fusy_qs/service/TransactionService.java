package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactionsByStudentId(Long studentId);
    void saveNewIndividualTransaction(Transaction newTransaction);
}