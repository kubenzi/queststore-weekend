package com.codecool.fusy_qs.repository;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.Level;
import com.codecool.fusy_qs.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}

