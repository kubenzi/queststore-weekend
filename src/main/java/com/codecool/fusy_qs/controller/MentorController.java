package com.codecool.fusy_qs.controller;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.Level;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.entity.User;
import com.codecool.fusy_qs.repository.UserRepository;
import com.codecool.fusy_qs.service.GroupService;
import com.codecool.fusy_qs.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MentorController {
    UserRepository userRepository;
    StudentService studentService;
    GroupService groupService;

    public MentorController(UserRepository userRepository, StudentService studentService, GroupService groupService) {
        this.userRepository = userRepository;
        this.studentService = studentService;
        this.groupService = groupService;
    }




    @GetMapping("/mentor/profile")
    String showMentorProfile(){

        return "mentors/profile";
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
    String showAddStudent(Student student, Model model){

        studentService.addStudent(student);

        return "mentors/add-student";
    }

    //Groups

    @GetMapping("/mentor/groups")
    String showAllGroups(Model model){

        return "mentors/groups";
    }

    @GetMapping("/mentor/edit-group/{id}")
    String showUpdateForm(@PathVariable("id") Long groupId, Model model) {
        GroupClass group = groupService.findGroupById(groupId);
        model.addAttribute(group);
        return "mentors/group-update";
    }

    @PostMapping("/mentor/update-group/{id}")
    String updateLevel(@PathVariable("id") Long groupId, GroupClass group, Model model) {

        groupService.saveGroup(group);

        return "redirect:/mentors/groups";
    }




}
