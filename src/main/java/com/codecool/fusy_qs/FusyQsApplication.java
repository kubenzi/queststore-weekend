package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.*;
import com.codecool.fusy_qs.repository.*;
import com.codecool.fusy_qs.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    private StudentService studentService;
    private LevelService levelService;
    private QuestRepository questRepository;


    public FusyQsApplication(QuestServiceImpl questService, QuestTypeService questTypeService,
                             AccountTypeService accountTypeService, GroupServiceImpl groupService,
                             StudentRepository studentRepository, GroupRepository groupRepository,
                             UserRepository userRepository, UserService userService,
                             StudentService studentService, LevelService levelService, QuestRepository questRepository) {
        this.questService = questService;
        this.questTypeService = questTypeService;
        this.accountTypeService = accountTypeService;
        this.groupService = groupService;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.studentService = studentService;
        this.levelService = levelService;
        this.questRepository = questRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(FusyQsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {


            Student kch = studentService.findStudentById(1L);

            Quest questNoOne = questRepository.findById(1L).orElse(null);
            Quest questNoTwo = questRepository.findById(2L).orElse(null);


            Achievement achievementOne = new Achievement();
            Achievement achievementTwo = new Achievement();
            Achievement achievementTree = new Achievement();

            achievementOne.setQuest(questNoOne);
            achievementTwo.setQuest(questNoTwo);
            achievementTree.setQuest(questNoTwo);


            kch.getAchievementList().add(achievementOne);
            kch.getAchievementList().add(achievementTwo);
            kch.getAchievementList().add(achievementTree);
            kch.getAchievementList().add(achievementTree);

            studentService.addStudent(kch);

        };

    }
}
