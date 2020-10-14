package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.GroupClass;
import com.codecool.fusy_qs.entity.Quest;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.entity.User;
import com.codecool.fusy_qs.repository.GroupRepository;
import com.codecool.fusy_qs.repository.StudentRepository;
import com.codecool.fusy_qs.repository.UserRepository;
import com.codecool.fusy_qs.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class FusyQsApplication {

    private QuestServiceImpl questService;
    private QuestTypeService questTypeService;
    private AccountTypeService accountTypeService;
    private GroupServiceImpl groupService;
    private StudentRepository studentRepository;
    private GroupRepository groupRepository;
    private UserRepository userRepository;
    private UserService userService;

    public FusyQsApplication(QuestServiceImpl questService, QuestTypeService questTypeService, AccountTypeService accountTypeService, GroupServiceImpl groupService, StudentRepository studentRepository, GroupRepository groupRepository, UserRepository userRepository, UserService userService) {
        this.questService = questService;
        this.questTypeService = questTypeService;
        this.accountTypeService = accountTypeService;
        this.groupService = groupService;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FusyQsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {

//            questService.addQuest(new Quest(questTypeService.findQuestTypeById(1L),
//                    "wash your car", 100));
//            questService.addQuest(new Quest(questTypeService.findQuestTypeById(1L),
//                    "clean your bedroom", 100));
//            questService.addQuest(new Quest(questTypeService.findQuestTypeById(2L),
//                    "make group project", 400));
//            questService.addQuest(new Quest(questTypeService.findQuestTypeById(2L),
//                    "build something", 500));
//
//            GroupClass java = groupService.findGroupById(3L);
//            GroupClass csharp = groupService.findGroupById(4L);
//
//            User bj = new Student("B", "J", "bj@gmail",
//                    "123", accountTypeService.findAccountTypeById(1L), 0, 1000);
//            User kch = new Student("K", "CH", "kch@gmail", "345",
//                    accountTypeService.findAccountTypeById(1L), 2, 1500);
//
//            User przemo = new User("Przemek", "Raczkowski", "przemek@gmail.com", "123", accountTypeService.findAccountTypeById(2L));
//
//
//
//            bj.getGroups().add(java);
//            bj.getGroups().add(csharp);
//            przemo.getGroups().add(java);
//            przemo.getGroups().add(csharp);
//
//            kch.getGroups().add(java);
//            kch.getGroups().add(csharp);
//
////            przemo.getGroups().add(java);
////            przemo.getGroups().add(csharp);
//
//            userRepository.save(bj); userRepository.save(kch); userRepository.save(przemo);
//
//
//            java.setUsers(Arrays.asList(bj, kch));
//            csharp.setUsers(Arrays.asList(bj, kch));
//            java.getUsers().add(przemo);
//
//
//
////            java.getUsers().add(bj);
////
////            java.getUsers().add(kch);
////
////            csharp.getUsers().add(bj);
////            csharp.getUsers().add(kch);
////
////            java.getUsers().add(przemo);
////            csharp.getUsers().add(przemo);
//
//
//            groupService.addGroup(java);
//            groupService.addGroup(csharp);


        };

    }
}
