package com.codecool.fusy_qs.controller;

import com.codecool.fusy_qs.dto.MentorDataDto;
import com.codecool.fusy_qs.dto.QuestDataDto;
import com.codecool.fusy_qs.dto.StudentGroupDataDto;
import com.codecool.fusy_qs.entity.*;
import com.codecool.fusy_qs.repository.UserRepository;
import com.codecool.fusy_qs.service.*;
import com.codecool.fusy_qs.entity.GroupClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {
    UserRepository userRepository;
    StudentService studentService;
    GroupService groupService;
    LevelService levelService;
    QuestService questService;
    UserService userService;
    AccountTypeService accountTypeService;
    AchievementService achievementService;
    QuestTypeService questTypeService;

    public MentorController(UserRepository userRepository, StudentService studentService, GroupService groupService,
                            LevelService levelService, QuestService questService, UserService userService,
                            AccountTypeService accountTypeService, AchievementService achievementService, QuestTypeService questTypeService) {
        this.userRepository = userRepository;
        this.studentService = studentService;
        this.groupService = groupService;
        this.levelService = levelService;
        this.questService = questService;
        this.userService = userService;
        this.accountTypeService = accountTypeService;
        this.achievementService = achievementService;
        this.questTypeService = questTypeService;
    }




    @GetMapping("/mentor/profile")
    String showMentorProfile(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        MentorDataDto mentorDataDto = new MentorDataDto();
        model.addAttribute("mentorDataDto", mentorDataDto);

        return "mentors/profile";
    }

    @PostMapping("/mentor/profile")
    String updateMentor(MentorDataDto mentorDataDto, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        User currentMentor = (User) session.getAttribute("mentor");

        if (mentorDataDto.getNewPassword() != null) {
            currentMentor.setPassword(mentorDataDto.getNewPassword());
        }

        if (mentorDataDto.getNewEmail() != null) {
            currentMentor.setEmail(mentorDataDto.getNewEmail());
        }

        userService.saveUser(currentMentor);

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
        Level studentLevel = levelService.getLevelByCcRequired(student.getTotalCoinsEarned());
        model.addAttribute("studentLevel", studentLevel);
        GroupClass studentGroup = student.getGroups().get(0);
        model.addAttribute("studentGroup", studentGroup);
        return "mentors/one-student";
    }

    @GetMapping("/mentor/addstudent")
    String showAddStudentForm(Model model){
//        Student student = new Student();
        StudentGroupDataDto newStudent = new StudentGroupDataDto();
        model.addAttribute("studentGroupDataDto", newStudent);


        return "mentors/add-student";
    }

    @GetMapping("/mentor/edit-student/{id}")
    String showUpdateStudentForm(@PathVariable("id") Long userId, Model model) {
        Student student = studentService.findStudentById(userId);
        model.addAttribute(student);
        return "mentors/student-update";
    }

    @PostMapping("/mentor/update-student/{id}")
    String updateStudent(@PathVariable("id") Long userId, Student student, Model model) {
        student.setPassword(studentService.findStudentById(userId).getPassword());
        student.setTotalCoinsEarned(studentService.findStudentById(userId).getTotalCoinsEarned());
        student.setWallet(studentService.findStudentById(userId).getWallet());
        student.setAccountType(studentService.findStudentById(userId).getAccountType());
        studentService.saveStudent(student);

        return "redirect:/mentor/student";
    }

    @GetMapping("/mentor/delete-student/{id}")
    String deleteStudent(@PathVariable("id") Long userId){
        Student student = studentService.findStudentById(userId);
//        for (Achievement achievement : student.getAchievementList()
//        )
//            achievementService.delete(achievement); {
//        }
//        for (int i = 0; i < student.getAchievementList().size(); i++) {
//            student.getAchievementList().set(i, null);
//        }
//        for (int i = 0; i < student.getAchievementList().size(); i++) {
//            student.getTransactionList().set(i, null);
//        }
//
////        student.getTransactionList().clear();
////        achievementService.delete(student.getAchievementList().);
//        studentService.saveStudent(student);
//        studentService.deleteStudent(student);

        return "redirect:/mentor/student";
    }

    @GetMapping("/mentor/delete-quest/{id}")
    String deleteQuest(@PathVariable("id") Long id){
        Quest quest = questService.getQuestById(id);
        questService.deleteQuest(quest);

        return "redirect:/mentor/quests";
    }

    @PostMapping("/mentor/newstudent")
    String addStudent(@ModelAttribute("studentGroupDataDto") StudentGroupDataDto studentGroupDataDto, Model model){

        Student newStudent = new Student();

        if(studentGroupDataDto.getFirstName() != null){
            newStudent.setFirstName(studentGroupDataDto.getFirstName());
        }

        if(studentGroupDataDto.getLastName() != null){
            newStudent.setLastName(studentGroupDataDto.getLastName());
        }

        if(studentGroupDataDto.getEmail() != null){
            newStudent.setEmail(studentGroupDataDto.getEmail());
        }

        if(studentGroupDataDto.getPassword() != null){
            newStudent.setPassword(studentGroupDataDto.getPassword());
        }

        if(studentGroupDataDto.getGroupId() != null){
            List <GroupClass> groupsList = new ArrayList<>();
            groupsList.add(groupService.findGroupById(studentGroupDataDto.getGroupId()));
            newStudent.setGroups(groupsList);
        }

        //Static values
        newStudent.setAccountType(accountTypeService.findAccountTypeById(1L));
        newStudent.setWallet(100);
        newStudent.setTotalCoinsEarned(100);

        studentService.addStudent(newStudent);

        return "redirect:/mentor/profile";
    }

    @GetMapping("/mentor/addquest")
    String showAddQuestForm(Model model){
        QuestDataDto questDataDto = new QuestDataDto();
        model.addAttribute("questDataDto", questDataDto);
        List<QuestType> questTypeList = questTypeService.findAllQuestTypes();
        model.addAttribute("questTypeList", questTypeList);

        return "mentors/add-quest";
    }

    @PostMapping("/mentor/newquest")
    String addQuest(@ModelAttribute("questDataDto") QuestDataDto questDataDto, Model model){

        Quest newQuest = new Quest();

        if(questDataDto.getQuestDescription() != null){
            newQuest.setQuestDescription(questDataDto.getQuestDescription());
        }

        if(questDataDto.getQuestValue() != 0){
            newQuest.setQuestValue(questDataDto.getQuestValue());
        }

        if(questDataDto.getQuestType() != null){
            newQuest.setQuestType(questTypeService.findQuestTypeById(questDataDto.getQuestType().getQuestTypeId()));
        }

        questService.saveQuest(newQuest);

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

        return "redirect:/mentor/groups";
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
