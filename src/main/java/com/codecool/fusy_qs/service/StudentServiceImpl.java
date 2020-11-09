package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.*;
import com.codecool.fusy_qs.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    QuestTypeService questTypeService;
    ItemTypeService itemTypeService;
    RequestService requestService;
    TransactionService transactionService;

    public StudentServiceImpl(StudentRepository studentRepository,
                              QuestTypeService questTypeService,
                              ItemTypeService itemTypeService,
                              RequestService requestService) {
        this.studentRepository = studentRepository;
        this.questTypeService = questTypeService;
        this.itemTypeService = itemTypeService;
        this.requestService = requestService;
    }

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public TransactionService getTransactionService() {
        return transactionService;
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Achievement> findIndividualAchievements(Student student) {
        List<Achievement> individualAchievements = new ArrayList<>();

        List<Achievement> allAchievements = student.getAchievementList();

        for(Achievement achievement : allAchievements) {
            if (achievement != null && achievement.getQuestType().equals(questTypeService.findQuestTypeById(1L))) {
                individualAchievements.add(achievement);
            }
        }
        return individualAchievements;
    }

    @Override
    public List<Achievement> findGroupAchievements(Student student) {
        List<Achievement> groupAchievements = new ArrayList<>();

        List<Achievement> allAchievements = student.getAchievementList();
        for(Achievement achievement : allAchievements) {
            if (achievement != null && achievement.getQuestType().equals(questTypeService.findQuestTypeById(2L))) {
                groupAchievements.add(achievement);
            }
        }
        return groupAchievements;
    }

    @Override
    public List<Transaction> findIndividualTransactions(Student student) {
        List<Transaction> individualTransactions = new ArrayList<>();

        List<Transaction> allTransactions = transactionService.getAllTransactionsByStudentId(student.getUserId());
        for(Transaction transaction : allTransactions) {
            if (transaction != null && transaction.getItemType().equals(itemTypeService.findItemTypeById(1L))) {
                individualTransactions.add(transaction);
            }
        }
        return individualTransactions;
    }

    @Override
    public List<Transaction> findGroupTransactions(Student student) {
        List<Transaction> groupTransactions = new ArrayList<>();
        List<Transaction> allTransactions = transactionService.getAllTransactionsByStudentId(student.getUserId());
        for(Transaction transaction : allTransactions) {
            if (transaction != null && transaction.getItemType().equals(itemTypeService.findItemTypeById(2L))) {
                groupTransactions.add(transaction);
            }
        }
        return groupTransactions;
    }

    @Override
    public List<Student> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public boolean checkAccountBalance(Student currentStudent, int coolcoins) {
        return currentStudent.getWallet() >= coolcoins;
    }

    @Override
    public void handleStartOfGroupPurchase(Student currentStudent, int coolcoins, Item item) {
        if (currentStudent.getWallet() < coolcoins) {
            coolcoins = currentStudent.getWallet();
        }

        currentStudent.setWallet(currentStudent.getWallet() - coolcoins);
        addStudent(currentStudent);

        RequestDetail newDetail = new RequestDetail(currentStudent, coolcoins);
        List<RequestDetail> details = Arrays.asList(newDetail);
        Request newRequest = new Request(item, currentStudent, details);
        requestService.saveRequest(newRequest);
    }

    @Override
    public void handleExistingGroupPurchase(Student currentStudent, int coolcoins, Request request) {
        if (currentStudent.getWallet() < coolcoins) {
            coolcoins = currentStudent.getWallet();
        }

        currentStudent.setWallet(currentStudent.getWallet() - coolcoins);
        addStudent(currentStudent);

        RequestDetail newDetail = new RequestDetail(currentStudent, coolcoins);
        request.getRequestDetails().add(newDetail);
        requestService.saveRequest(request);
    }

    @Override
    public void handleIndividualItemPurchase(Student currentStudent, Item boughtItem) {
        currentStudent.setWallet(currentStudent.getWallet() - boughtItem.getItemCost());
        Transaction newTransaction = new Transaction(boughtItem.getItemName(), boughtItem.getItemDescription(),
                boughtItem.getItemCost(), false, currentStudent);

        transactionService.saveNewIndividualTransaction(newTransaction);
    }
}
