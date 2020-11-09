package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.*;

import java.util.List;

public interface StudentService {

    Student findStudentById(Long id);
    Student findStudentByEmail(String email);
    void addStudent(Student student);
    List<Achievement> findGroupAchievements(Student student);
    List<Achievement> findIndividualAchievements(Student student);
    List<Transaction> findGroupTransactions(Student student);
    List<Transaction> findIndividualTransactions(Student student);
    boolean checkAccountBalance(Student currentStudent, int coolcoins);
    List<Student> findAllStudents();
    void saveStudent(Student student);
    void deleteStudent(Student student);
    void handleStartOfGroupPurchase(Student currentStudent, int coolcoins, Item item);
    void handleExistingGroupPurchase(Student currentStudent, int coolcoins, Request request);
    void handleIndividualItemPurchase(Student currentStudent, Item boughtItem);
}
