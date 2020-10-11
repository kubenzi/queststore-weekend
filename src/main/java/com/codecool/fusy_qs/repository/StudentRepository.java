package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
