package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.Level;
import com.codecool.fusy_qs.entity.Quest;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.repository.LevelRepository;
import com.codecool.fusy_qs.repository.StudentRepository;
import com.codecool.fusy_qs.service.QuestService;
import com.codecool.fusy_qs.service.QuestTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    QuestService questService;
    StudentRepository studentRepository;
    LevelRepository levelRepository;

    public UserController(QuestService questService, StudentRepository studentRepository, LevelRepository levelRepository) {
        this.questService = questService;
        this.studentRepository = studentRepository;
        this.levelRepository = levelRepository;
    }

    private Student getStudent(){
        Student student = studentRepository.findById(1L).orElse(null);
        return student;
    }

    private Level getLevel(){
        return levelRepository.findLevelByCoolcoinsRequired(getStudent().getTotalCoinsEarned());
    }

    @GetMapping("/student")
    String showStudentsQuests(Model model) {


        model.addAttribute("student", getStudent());
        model.addAttribute("level", getLevel());

        return "students/student";
    }

    @GetMapping("/experience")
    String showTransaction(Model model) {

        List<Level> levelslist = (List<Level>) levelRepository.findAll();

        model.addAttribute("student", getStudent());
        model.addAttribute("levelslist", levelslist);
        model.addAttribute("level", getLevel());

        return "students/experience";
    }


//    @GetMapping("/edit-level")
//    String showTransaction(Model model) {
//
//        List<Level> levelslist = (List<Level>) levelRepository.findAll();
//
//        model.addAttribute("student", getStudent());
//        model.addAttribute("levelslist", levelslist);
//        model.addAttribute("level", getLevel());
//
//        return "students/experience";
//    }

}
