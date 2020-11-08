package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Request;
import com.codecool.fusy_qs.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactionsByStudentId(Long studentId);
    void saveNewIndividualTransaction(Transaction newTransaction);
    void saveElementOfGroupTransaction(Transaction newTransaction);
    Transaction findTransactionById(Long id);
    void useBoughtIndividualItem(Transaction transaction);
    void saveNewGroupTransaction(Request completedRequest);
    List<Transaction> removeDuplicatesFromTransactionList(List<Transaction> transactionList);
}
