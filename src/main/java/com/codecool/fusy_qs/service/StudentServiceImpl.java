package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }


//    @Query("select u from groups_users u where u.users_user_id = ?1")
//    public List<Group> findGroupsByStudentId(Long id){
//
//    }

}
