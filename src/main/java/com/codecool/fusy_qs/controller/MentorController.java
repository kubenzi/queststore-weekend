package com.codecool.fusy_qs.controller;

import com.codecool.fusy_qs.entity.*;
import com.codecool.fusy_qs.repository.UserRepository;
import com.codecool.fusy_qs.service.GroupService;
import com.codecool.fusy_qs.service.LevelService;
import com.codecool.fusy_qs.service.QuestService;
import com.codecool.fusy_qs.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MentorController {
    UserRepository userRepository;
    StudentService studentService;
    GroupService groupService;
    LevelService levelService;
    QuestService questService;

    public MentorController(UserRepository userRepository, StudentService studentService, GroupService groupService,
                            LevelService levelService, QuestService questService) {
        this.userRepository = userRepository;
        this.studentService = studentService;
        this.groupService = groupService;
        this.levelService = levelService;
        this.questService = questService;
    }




    @GetMapping("/mentor/profile")
    String showMentorProfile(){

        return "mentors/profile";
    }


    @GetMapping("/mentor/shop/group")
    String showGroupShop(){

        return "mentors/shop-group";
    }

    @GetMapping("/mentor/shop/individual")
    String showIndividualShop(){

        return "mentors/shop-individual";
    }
    //Students

    @GetMapping("/mentor/student")
    String showChooseStudentProfile(Model model){
        List<Student> studentsList = studentService.findAllStudents();
        model.addAttribute("studentsList", studentsList);
        return "mentors/student";
    }

    @GetMapping(value = "/mentor/one-student/{id}")
    String showStudentProfile(@PathVariable("id") String userId, Model model){
        Student student = studentService.findStudentById(Long.valueOf(userId));
        model.addAttribute(student);
        return "mentors/one-student";
    }

    @GetMapping("/mentor/addstudent")
    String showAddStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);

        return "mentors/add-student";
    }

    @PostMapping("/mentor/newstudent")
    String addStudent(@ModelAttribute("student") Student student, Model model){

        model.addAttribute("firstName", student.getFirstName());
        model.addAttribute("lastName", student.getLastName());
        model.addAttribute("email", student.getEmail());
        model.addAttribute("password", student.getPassword());
        model.addAttribute("group", student.getGroups().get(0));
        studentService.addStudent(student);

        return "redirect:/mentor/profile";
    }

    //Groups

    @GetMapping("/mentor/groups")
    String showAllGroups(Model model){

        return "mentors/groups";
    }

    @GetMapping("/mentor/edit-group/{id}")
    String showUpdateGroupForm(@PathVariable("id") Long groupId, Model model) {
        GroupClass group = groupService.findGroupById(groupId);
        model.addAttribute(group);
        return "mentors/group-update";
    }

    @PostMapping("/mentor/update-group/{id}")
    String updateLevel(@PathVariable("id") Long groupId, GroupClass group, Model model) {

        groupService.saveGroup(group);

        return "redirect:/mentors/groups";
    }

    //Level

    @GetMapping("/mentor/experience")
    String showTransaction(Model model) {

        List<Level> levelslist = levelService.getAllLevels();

        model.addAttribute("levelslist", levelslist);

        return "mentors/experience";
    }


    @GetMapping("/mentor/edit-level/{id}")
    String showUpdateLevelForm(@PathVariable("id") Long levelId, Model model) {
        Level level = levelService.getLevelById(levelId);
        model.addAttribute(level);
        return "mentors/experience-update";
    }

    @PostMapping("/mentor/update-level/{id}")
    String updateLevel (@PathVariable("id") Integer levelId, Level level,  Model model) {

        levelService.saveLevel(level);

        return "redirect:/mentor/experience";
    }

    //Quests

    @GetMapping("/mentor/quests")
    String getQuests(Model model) {
        List<Quest> individualQuests = questService.getAllIndividualQuests();
        List<Quest> groupQuests = questService.getAllGroupQuests();

        model.addAttribute("individualQuests", individualQuests);
        model.addAttribute("groupQuests", groupQuests);

        return "mentors/quests";
    }

    @GetMapping("/mentor/edit-quest/{id}")
    String showUpdateQuestForm(@PathVariable("id") Long questId, Model model) {
        Quest quest = questService.getQuestById(questId);
        model.addAttribute(quest);
        return "mentors/quest-update";
    }

    @PostMapping("/mentor/update-quest/{id}")
    String updateLevel (@PathVariable("id") Integer questId, Quest quest,  Model model) {

        questService.saveQuest(quest);

        return "redirect:/mentor/quests";
    }
}
