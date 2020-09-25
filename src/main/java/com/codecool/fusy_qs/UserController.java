package com.codecool.fusy_qs;

import com.codecool.fusy_qs.DAO.StudentDao;
import com.codecool.fusy_qs.Model.Student;
import com.codecool.fusy_qs.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private StudentService studentService;

    public UserController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    String showStudentPage(Model model) {
        Student student = studentService.getStudentById("JgsMz0d1");

//        System.out.println(student.toString());
        model.addAttribute(student);
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
