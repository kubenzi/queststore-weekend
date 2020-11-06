package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Transaction;
import com.codecool.fusy_qs.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
