package com.codecool.fusy_qs.Service;

import com.codecool.fusy_qs.DAO.StudentDao;
import com.codecool.fusy_qs.Model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudentById(String id){
        return studentDao.getStudentByID(id);
    }
}
