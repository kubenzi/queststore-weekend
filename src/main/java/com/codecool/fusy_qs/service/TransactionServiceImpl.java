package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Request;
import com.codecool.fusy_qs.entity.RequestDetail;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.entity.Transaction;
import com.codecool.fusy_qs.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private ItemTypeService itemTypeService;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  ItemTypeService itemTypeService) {
        this.transactionRepository = transactionRepository;
        this.itemTypeService = itemTypeService;
    }

    @Override
    public List<Transaction> getAllTransactionsByStudentId(Long studentId) {
        return transactionRepository.getAllTransactionsByStudentId(studentId);
    }

    @Override
    public void saveNewIndividualTransaction(Transaction newTransaction) {
        newTransaction.setItemType(itemTypeService.findItemTypeById(1L));

        transactionRepository.save(newTransaction);
    }

    @Override
    public Transaction findTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void useBoughtIndividualItem(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void saveNewGroupTransaction(Request completedRequest) {

    }
}
