package com.codecool.fusy_qs.controller;

import com.codecool.fusy_qs.entity.Level;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.entity.User;
import com.codecool.fusy_qs.repository.StudentRepository;
import com.codecool.fusy_qs.service.LevelService;
import com.codecool.fusy_qs.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    QuestService questService;
    StudentRepository studentRepository;
    LevelService levelService;


    public StudentController(QuestService questService, StudentRepository studentRepository, LevelService levelService) {
        this.questService = questService;
        this.studentRepository = studentRepository;
        this.levelService = levelService;
    }

    private Student getStudent(){
        Student student = studentRepository.findById(1L).orElse(null);
        return student;
    }

    private Level getLevel(){
        return levelService.getLevelByCcRequired(getStudent().getTotalCoinsEarned());
    }

    @GetMapping("/student")
    String showStudentsQuests(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        Student student = (Student) session.getAttribute("student");


        return "students/student";
    }

    @GetMapping("/experience")
    String showTransaction(Model model) {

        List<Level> levelslist = levelService.getAllLevels();

        model.addAttribute("levelslist", levelslist);

        return "students/experience";
    }


    @GetMapping("/edit-level/{id}")
    String showUpdateForm(@PathVariable("id") Long levelId, Model model) {

        return "students/experience-update";
    }

    @PostMapping("/update-level/{id}")
    String updateLevel (@PathVariable("id") Integer levelId, Level level,  Model model) {

        levelService.saveLevel(level);

        return "redirect:/experience";
    }

    @GetMapping("/login")
    String login() {

        return "loginForm";
    }


}
