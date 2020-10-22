package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> login(User validUser);
    User findUserById(Long id);
    User findUserByEmail(String email);
    void deleteUserById(Long Id);
    User saveUser(User user);

}
