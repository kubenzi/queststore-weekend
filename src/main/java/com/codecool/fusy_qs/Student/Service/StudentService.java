package com.codecool.fusy_qs.Student.Service;

import com.codecool.fusy_qs.Student.DAO.StudentDao;
import com.codecool.fusy_qs.Student.Model.Student;
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
