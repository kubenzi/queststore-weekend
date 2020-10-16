package com.codecool.fusy_qs.controller;

import com.codecool.fusy_qs.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MentorController {
    UserRepository userRepository;

    public MentorController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    String showMentorProfile(){

        return "mentors/profile";
    }
}
