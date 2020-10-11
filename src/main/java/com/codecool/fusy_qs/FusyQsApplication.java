package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.Group;
import com.codecool.fusy_qs.entity.Quest;
import com.codecool.fusy_qs.entity.Student;
import com.codecool.fusy_qs.repository.StudentRepository;
import com.codecool.fusy_qs.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FusyQsApplication {

    private QuestServiceImpl questService;
    private QuestTypeService questTypeService;
    private AccountTypeService accountTypeService;
    private GroupServiceImpl groupService;
    private StudentRepository studentRepository;

    public FusyQsApplication(QuestServiceImpl questService, QuestTypeServiceIMPL questTypeService, AccountTypeService accountTypeService, GroupServiceImpl groupService, StudentRepository studentRepository) {
        this.questService = questService;
        this.questTypeService = questTypeService;
        this.accountTypeService = accountTypeService;
        this.groupService = groupService;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FusyQsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {

            questService.addQuest(new Quest(questTypeService.findQuestTypeById(1L),
                    "wash your car", 100));
            questService.addQuest(new Quest(questTypeService.findQuestTypeById(1L),
                    "clean your bedroom", 100));
            questService.addQuest(new Quest(questTypeService.findQuestTypeById(2L),
                    "make group project", 400));
            questService.addQuest(new Quest(questTypeService.findQuestTypeById(2L),
                    "build something", 500));

            Group java = groupService.findGroupById(2L);
            Group csharp = groupService.findGroupById(3L);

            List<Group> groups = Arrays.asList(groupService.findGroupById(2L), csharp);

            Student bj = new Student("B", "J", "bj@gmail",
                    "123", accountTypeService.findAccountTypeById(1L),
                    groups, 0, 23);
            Student kch = new Student("K", "CH", "kch@gmail", "345", accountTypeService.findAccountTypeById(1L),
                    groups, 2, 22);

            studentRepository.save(bj); studentRepository.save(kch);

            java.setUser(bj);
            csharp.setUser(bj);

            groupService.addGroup(java);
            groupService.addGroup(csharp);

            bj.setGroups(groups);


//            java.setUser(kch);
//            csharp.setUser(kch);

            groupService.addGroup(java);
            groupService.addGroup(csharp);

            kch.setGroups(groups);



        };

    }
}
