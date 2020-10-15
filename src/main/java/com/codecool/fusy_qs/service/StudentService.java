package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.Student;

public interface StudentService {

    Student findStudentById(Long id);
    Student findStudentByEmail(String email);
    void addStudent(Student student);
}
