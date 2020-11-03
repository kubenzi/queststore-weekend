package com.codecool.fusy_qs.controller;

import com.codecool.fusy_qs.entity.*;
import com.codecool.fusy_qs.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    QuestService questService;
    StudentService studentService;
    LevelService levelService;
    AchievementService achievementService;
    ItemService itemService;
    RequestService requestService;

    public StudentController(QuestService questService,
                             StudentService studentService,
                             LevelService levelService,
                             AchievementService achievementService,
                             ItemService itemService,
                             RequestService requestService) {
        this.questService = questService;
        this.studentService = studentService;
        this.levelService = levelService;
        this.achievementService = achievementService;
        this.itemService = itemService;
        this.requestService = requestService;
    }

    @GetMapping("/student/profile")
    String getStudentProfile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        return "students/student";
    }

    @GetMapping("/student/experience")
    String getLevels(Model model) {
        List<Level> levelslist = levelService.getAllLevels();
        model.addAttribute("levelslist", levelslist);

        return "students/experience";
    }

    @GetMapping("/student/achievements")
    String getAchievements(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Student student = (Student) session.getAttribute("student");

        List<Achievement> individualAchievements = studentService.findIndividualAchievements(student);
        List<Achievement> groupAchievements = studentService.findGroupAchievements(student);

        model.addAttribute("individualAchievements", individualAchievements);
        model.addAttribute("groupAchievements", groupAchievements);
        model.addAttribute("totalIndividualValue", achievementService.calculateTotalValueOfAchievementsList(individualAchievements));
        model.addAttribute("totalGroupValue", achievementService.calculateTotalValueOfAchievementsList(groupAchievements));

        return "students/achievements";
    }

    @GetMapping("/student/transactions")
    String getTransactions(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Student student = (Student) session.getAttribute("student");

        List<Transaction> individualTransactions = studentService.findIndividualTransactions(student);
        List<Transaction> groupTransactions = studentService.findGroupTransactions(student);

        model.addAttribute("individualTransactions", individualTransactions);
        model.addAttribute("groupTransactions", groupTransactions);

        return "students/transactions";
    }

    @GetMapping("/student/edit-level/{id}")
    String showUpdateForm(@PathVariable("id") Long levelId, Model model) {
        Level level = levelService.getLevelById(levelId);
        model.addAttribute(level);
        return "students/experience-update";
    }

    @PostMapping("/student/update-level/{id}")
    String updateLevel (@PathVariable("id") Integer levelId, Level level,  Model model) {

        levelService.saveLevel(level);

        return "redirect:/student/experience";
    }

    @GetMapping("/login")
    String login() {

        return "loginForm";
    }

    @GetMapping("/student/group")
    String getGroup(Model model) {

        List<Level> levelslist = levelService.getAllLevels();
        model.addAttribute("levelslist", levelslist);

        return "students/group";
    }

    @GetMapping("/student/quests")
    String getQuests(Model model) {
        List<Quest> individualQuests = questService.getAllIndividualQuests();
        List<Quest> groupQuests = questService.getAllGroupQuests();

        model.addAttribute("individualQuests", individualQuests);
        model.addAttribute("groupQuests", groupQuests);

        return "students/quests";
    }

    @GetMapping("/student/shop-individual")
    String getIndividualItems(Model model) {
        List<Item> individualItems = itemService.getAllIndividualItems();
        model.addAttribute("individualItems", individualItems);

        return "students/shop-individual";
    }

    @GetMapping("/student/shop-individual/{id}")
    String showIndividualItemPage(@PathVariable("id") Long itemId, Model model) {
        Item item = itemService.getItemById(itemId);
        model.addAttribute("item", item);
        return "students/shop-individual-item";
    }

    @PostMapping("/student/shop-individual/{id}")
    String buyIndividualItem(@PathVariable("id" ) Long itemId, HttpServletRequest request) {
        Item boughtItem = itemService.getItemById(itemId);
        HttpSession session = request.getSession(true);
        Student currentStudent = (Student) session.getAttribute("student");

        if (!studentService.validateAccountBalance(currentStudent, boughtItem.getItemCost()))
            return "redirect:/student/shop-individual";

        currentStudent.setWallet(currentStudent.getWallet() - boughtItem.getItemCost());
        Transaction newTransaction = new Transaction(boughtItem.getItemName(), boughtItem.getItemDescription(),
                boughtItem.getItemCost(), false);

        studentService.addNewIndividualTransaction(newTransaction, currentStudent);

        return "redirect:/student/shop-individual";
    }

    @GetMapping("/student/shop-group")
    String getGroupItems(Model model) {
        List<Item> groupItems = itemService.getAllGroupItems();
        model.addAttribute("groupItems", groupItems);

        return "students/shop-group";
    }

    @GetMapping("/student/shop-group/{id}")
    String showGroupItemPage(@PathVariable("id") Long itemId, Model model) {
        Item item = itemService.getItemById(itemId);
        model.addAttribute("item", item);
        return "students/shop-group-item";
    }

    @GetMapping("/student/shop-group-shopping")
    String getGroupShopping(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Student student = (Student) session.getAttribute("student");

        List<Request> groupRequests = requestService.getCurrentGroupRequests(student.getGroups().get(0).getGroupId());
        model.addAttribute("groupRequests", groupRequests);

        return "students/shop-group-shopping";
    }
}
