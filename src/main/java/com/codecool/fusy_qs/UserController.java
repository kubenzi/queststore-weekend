package com.codecool.fusy_qs;

import com.codecool.fusy_qs.Group.Model.Group;
import com.codecool.fusy_qs.Group.Service.GroupService;
import com.codecool.fusy_qs.Level.Model.Level;
import com.codecool.fusy_qs.Level.Service.LevelService;
import com.codecool.fusy_qs.Student.Model.Student;
import com.codecool.fusy_qs.Student.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private StudentService studentService;
    private GroupService groupService;
    private LevelService levelService;

    public UserController(StudentService studentService, GroupService groupService, LevelService levelService) {
        this.studentService = studentService;
        this.groupService = groupService;
        this.levelService = levelService;
    }

    @GetMapping("/student")
    String showStudentPage(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);


        return "students/student";

    }

    @GetMapping("/achievements")
    String showStudentsAchievements(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/achievements";
    }

    @GetMapping("/quests")
    String showStudentsQuests(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/quests";
    }

    @GetMapping("/shop-class")
    String showStudentsShopClass(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/shop-class";
    }

    @GetMapping("/shop-group")
    String showStudentsShopGroup(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/shop-group";
    }

    @GetMapping("/shop-individual")
    String showStudentsShopIndividual(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/shop-individual";
    }

    @GetMapping("/class")
    String showClass(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/class";
    }

    @GetMapping("/group")
    String showGroup(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/group";
    }

    @GetMapping("/experience")
    String showExperience(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());


        List<Level> levelList = levelService.getAllLevels();

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);
        model.addAttribute("levelslist", levelList);


        return "students/experience";
    }

    @GetMapping("/edit-level/{id}")
    String showUpdateForm(@PathVariable("id") Integer levelId, Model model) {

        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());

        model.addAttribute("student", student);
        model.addAttribute("group", group);


        Level level = levelService.getLevelById(levelId);
        model.addAttribute("level", level);
        return "students/experience-update";
    }

    @PostMapping("/update-level/{id}")
    String updateLevel (@PathVariable("id") Integer levelId, Level level,  Model model) {

        System.out.println(level.toString());
        System.out.println(level.getIconName());
        levelService.editLevel(level);




        return "redirect:/experience";
    }

    @GetMapping("/transactions")
    String showTransaction(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/transactions";

    }




}
