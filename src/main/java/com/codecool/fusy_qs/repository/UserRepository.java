package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}

