package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Level;
import com.codecool.fusy_qs.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByEmail(String email);

    @Query(value = "SELECT * FROM user_data", nativeQuery = true)
    List<Student> findAllStudents();
}
