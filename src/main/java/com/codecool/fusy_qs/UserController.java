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

    @GetMapping("student")
    String showStudentPage(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");

        Group group = groupService.getGroupById(student.getGroupId());
        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());

        model.addAttribute("student", student);
        model.addAttribute("group", group);
        model.addAttribute("level", level);

        return "students/student";
    }

    @GetMapping("achievements")
    String showStudentsAchievements(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);

        return "students/achievements";
    }

    @GetMapping("quests")
    String showStudentsQuests(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);
        return "students/quests";
    }

    @GetMapping("shop-class")
    String showStudentsShopClass(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);
        return "students/shop-class";
    }

    @GetMapping("shop-group")
    String showStudentsShopGroup(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);
        return "students/shop-group";
    }

    @GetMapping("shop-individual")
    String showStudentsShopIndividual(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);
        return "students/shop-individual";
    }

    @GetMapping("class")
    String showClass(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);
        return "students/class";
    }

    @GetMapping("group")
    String showGroup(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);
        return "students/group";
    }

    @GetMapping("experience")
    String showExperience(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);
        return "students/experience";
    }

    @GetMapping("transactions")
    String showTransaction(Model model) {
        Student student = studentService.getStudentById(")+e)CWq!");
        model.addAttribute(student);
        return "students/transactions";

    }
}
