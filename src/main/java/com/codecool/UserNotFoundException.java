package com.codecool;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User nor found for given id: " + id);
    }
}
