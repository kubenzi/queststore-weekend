package com.codecool.fusy_qs.service;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.User;
import com.codecool.fusy_qs.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<User> login(User validUser) {
        return getAllUsers().stream()
                .filter(user -> user.getEmail().equals(validUser.getEmail())
                        && user.getPassword().equals(validUser.getPassword()))
                .findAny();
    }
}
