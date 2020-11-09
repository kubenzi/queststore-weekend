package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Request;
import com.codecool.fusy_qs.entity.RequestDetail;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.entity.Transaction;
import com.codecool.fusy_qs.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private ItemTypeService itemTypeService;
    private RequestService requestService;
    private RequestDetailService requestDetailService;
    private StudentService studentService;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  ItemTypeService itemTypeService,
                                  RequestService requestService,
                                  RequestDetailService requestDetailService) {
        this.transactionRepository = transactionRepository;
        this.itemTypeService = itemTypeService;
        this.requestService = requestService;
        this.requestDetailService = requestDetailService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentService getStudentService() {
        return studentService;
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
    public void saveElementOfGroupTransaction(Transaction newTransaction) {
        transactionRepository.save(newTransaction);
    }

    @Override
    public Transaction findTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void useBoughtIndividualItem(Transaction transaction) {
        transaction.setIsUsed(true);
        transactionRepository.save(transaction);
    }

    @Override
    public void saveNewGroupTransaction(Request completedRequest) {
        Map<Long, Integer> completedRequestMap = requestService.createGroupPurchaseMap(completedRequest);

        for(Map.Entry<Long, Integer> entry : completedRequestMap.entrySet()) {
            Transaction newTransaction = new Transaction();
            newTransaction.setItemName(completedRequest.getItemName());
            newTransaction.setItemDescription(completedRequest.getItemDescription());
            newTransaction.setStudent(studentService.findStudentById(entry.getKey()));
            newTransaction.setItemCost(entry.getValue());
            newTransaction.setIsUsed(true);
            newTransaction.setItemType(completedRequest.getItemType());
            saveElementOfGroupTransaction(newTransaction);

            Student currentStudent = studentService.findStudentById(entry.getKey());
            List<Transaction> filteredTransactions =
                    removeDuplicatesFromTransactionList(currentStudent.getTransactionList());
            filteredTransactions.add(newTransaction);
            currentStudent.setTransactionList(filteredTransactions);
            studentService.addStudent(currentStudent);
        }

        requestService.deleteRequestWithDetails(completedRequest);
    }

    @Override
    public List<Transaction> removeDuplicatesFromTransactionList(List<Transaction> transactionList) {
        Set<Long> setOfIdNumbers = new HashSet<>();
        List<Transaction> filteredTransactionList = new ArrayList<>();

        for (Transaction transaction : transactionList) {
            setOfIdNumbers.add(transaction.getId());
        }

        for (Long id : setOfIdNumbers) {
            filteredTransactionList.add(findTransactionById(id));
        }

        return filteredTransactionList;
    }
}
