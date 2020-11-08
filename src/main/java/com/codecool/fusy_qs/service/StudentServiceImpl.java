package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Achievement;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.entity.Transaction;
import com.codecool.fusy_qs.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    QuestTypeService questTypeService;
    ItemTypeService itemTypeService;
    TransactionService transactionService;

    public StudentServiceImpl(StudentRepository studentRepository,
                              QuestTypeService questTypeService,
                              ItemTypeService itemTypeService) {
        this.studentRepository = studentRepository;
        this.questTypeService = questTypeService;
        this.itemTypeService = itemTypeService;
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
}
