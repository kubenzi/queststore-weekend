package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.Mentor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, Long> {

    Mentor findByEmail(String email);


}
