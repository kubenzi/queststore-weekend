package com.codecool.fusy_qs.service;

import com.codecool.UserNotFoundException;
import com.codecool.fusy_qs.entity.User;
import com.codecool.fusy_qs.repository.GroupRepository;
import com.codecool.fusy_qs.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteUserById(Long Id) {
    try {
        userRepository.deleteById(Id);
    } catch (EmptyResultDataAccessException e) {
        throw new UserNotFoundException(Id);
    }
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
