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

    @GetMapping("/mentor/profile")
    String showMentorProfile(){

        return "mentors/profile";
    }

    @GetMapping("/mentor/addstudent")
    String showAddStudent(){

        return "mentors/add-student";
    }

    @GetMapping("/mentor/groups")
    String showAllGroups(){

        return "mentors/groups";
    }

    @GetMapping("/mentor/quests")
    String showAllQuests(){

        return "mentors/quests";
    }

    @GetMapping("/mentor/shop/group")
    String showGroupShop(){

        return "mentors/shop-group";
    }

    @GetMapping("/mentor/shop/individual")
    String showIndividualShop(){

        return "mentors/shop-individual";
    }

    @GetMapping("/mentor/student")
    String showStudentProfile(){

        return "mentors/student";
    }



}
