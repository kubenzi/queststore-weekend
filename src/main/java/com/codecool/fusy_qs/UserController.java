package com.codecool.fusy_qs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class UserController {



    @GetMapping("student")
    String showStudentPage( ) {
        return "students/student";
    }

    @GetMapping("achievements")
    String showStudentsAchievements( ) {
        return "students/achievements";
    }

    @GetMapping("quests")
    String showStudentsQuests( ) {
        return "students/quests";
    }

    @GetMapping("shop-class")
    String showStudentsShopClass( ) {
        return "students/shop-class";
    }

    @GetMapping("shop-group")
    String showStudentsShopGroup( ) {
        return "students/shop-group";
    }

    @GetMapping("shop-individual")
    String showStudentsShopIndividual( ) {
        return "students/shop-individual";
    }

    @GetMapping("class")
    String showClass( ) {
        return "students/class";
    }

    @GetMapping("group")
    String showGroup( ) {
        return "students/group";
    }

    @GetMapping("experience")
    String showExperience( ) {
        return "students/experience";
    }

    @GetMapping("transactions")
    String showTransaction( ) {
        return "students/transactions";
    }

}
