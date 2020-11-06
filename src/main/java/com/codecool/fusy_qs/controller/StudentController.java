package com.codecool.fusy_qs.controller;


import com.codecool.fusy_qs.dto.GroupPurchaseDto;
import com.codecool.fusy_qs.dto.StudentDataDto;
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
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    QuestService questService;
    StudentService studentService;
    LevelService levelService;
    AchievementService achievementService;
    ItemService itemService;
    RequestService requestService;
    RequestDetailService requestDetailService;
    TransactionService transactionService;

    public StudentController(QuestService questService,
                             StudentService studentService,
                             LevelService levelService,
                             AchievementService achievementService,
                             ItemService itemService,
                             RequestService requestService,
                             TransactionService transactionService,
                             RequestDetailService requestDetailService) {
        this.questService = questService;
        this.studentService = studentService;
        this.levelService = levelService;
        this.achievementService = achievementService;
        this.itemService = itemService;
        this.requestService = requestService;
        this.transactionService = transactionService;
        this.requestDetailService = requestDetailService;
    }


    @GetMapping("/student/profile")
    String getStudentProfile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        StudentDataDto studentDataDto = new StudentDataDto();
        model.addAttribute("studentDataDto", studentDataDto);

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
    String updateLevel(@PathVariable("id") Integer levelId, Level level, Model model) {

        levelService.saveLevel(level);

        return "redirect:/student/experience";
    }

    @PostMapping("/student")
        String updateStudent(StudentDataDto studentDataDto, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        Student currentStudent = (Student) session.getAttribute("student");

        if (studentDataDto.getNewPassword() != null) {
            currentStudent.setPassword(studentDataDto.getNewPassword());
        }

        if (studentDataDto.getNewEmail() != null) {
            currentStudent.setEmail(studentDataDto.getNewEmail());
        }

        studentService.addStudent(currentStudent);

        return "students/student";
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
    String buyIndividualItem(@PathVariable("id") Long itemId, HttpServletRequest request) {
        Item boughtItem = itemService.getItemById(itemId);
        HttpSession session = request.getSession(true);
        Student currentStudent = (Student) session.getAttribute("student");

        if (!studentService.checkAccountBalance(currentStudent, boughtItem.getItemCost()))
            return "redirect:/student/shop-individual";

        currentStudent.setWallet(currentStudent.getWallet() - boughtItem.getItemCost());
        Transaction newTransaction = new Transaction(boughtItem.getItemName(), boughtItem.getItemDescription(),
                boughtItem.getItemCost(), false, currentStudent);

        transactionService.saveNewIndividualTransaction(newTransaction);

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
        GroupPurchaseDto coolcoinsSent = new GroupPurchaseDto();
        model.addAttribute("item", item);
        model.addAttribute("coolcoinsSent", coolcoinsSent);
        return "students/shop-group-item";
    }

    @PostMapping("/student/shop-group/{id}")
    String buyGroupItemPage(@PathVariable("id") Long itemId,
                            @ModelAttribute("coolcoinsSent") GroupPurchaseDto coolcoinsSent,
                            HttpServletRequest request) {
        Item item = itemService.getItemById(itemId);
        HttpSession session = request.getSession(true);
        Student currentStudent = (Student) session.getAttribute("student");
        int coolcoins = coolcoinsSent.getCoolcoins();

        if (currentStudent.getWallet() < coolcoins) {
            coolcoins = currentStudent.getWallet();
        }

        currentStudent.setWallet(currentStudent.getWallet() - coolcoins);

        RequestDetail newDetail = new RequestDetail(currentStudent, coolcoins);
        requestDetailService.saveRequestDetail(newDetail);
        List<RequestDetail> details = Arrays.asList(newDetail);
        Request newRequest = new Request(item, currentStudent, details);
        requestService.saveNewRequest(newRequest);
        newDetail.setRequest(newRequest);
        requestDetailService.saveRequestDetail(newDetail);

        return "redirect:/student/shop-group-shopping";
    }

    @GetMapping("/student/shop-group-shopping")
    String getGroupShopping(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Student student = (Student) session.getAttribute("student");

        List<Request> groupRequests = requestService.getCurrentGroupRequests(student.getGroups().get(0).getGroupId());
        model.addAttribute("groupRequests", groupRequests);

        return "students/shop-group-shopping";
    }

    @GetMapping("/student/shop-group-shopping-details/{id}")
    String showGroupRequestDetails(@PathVariable("id") Long id,
                                   Model model) {
        Request request = requestService.findRequestById(id);
        model.addAttribute("currentRequest", request);

        return "students/shop-group-shopping-details";
    }

}
