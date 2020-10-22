package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.*;
import com.codecool.fusy_qs.repository.*;
import com.codecool.fusy_qs.repository.RequestDetailsReposiotry;
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
    private ItemRepository itemRepository;
    private ItemService itemService;
    private RequestDetailsReposiotry requestDetailsReposiotry;
    private RequestRepository requestRepository;


    public FusyQsApplication(QuestServiceImpl questService, QuestTypeService questTypeService,
                             AccountTypeService accountTypeService, GroupServiceImpl groupService,
                             StudentRepository studentRepository, GroupRepository groupRepository,
                             UserRepository userRepository, UserService userService,
                             StudentService studentService, LevelService levelService, QuestRepository questRepository,
                             ItemRepository itemRepository, ItemService itemService, RequestDetailsReposiotry requestDetailsReposiotry, RequestRepository requestRepository) {
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
        this.itemRepository = itemRepository;
        this.itemService = itemService;
        this.requestDetailsReposiotry = requestDetailsReposiotry;
        this.requestRepository = requestRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FusyQsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {


            Student kch = studentService.findStudentById(1L);

//            Quest questNoOne = questRepository.findById(1L).orElse(null);
//            Quest questNoTwo = questRepository.findById(2L).orElse(null);
//
//            Item itemNoOne = itemService.getItemById(1L);
//            Item itemNoTwo = itemService.getItemById(2L);
//            Item itemNoTree = itemService.getItemById(3L);
//
//            Transaction transactionOne = new Transaction(itemNoOne);
//            Transaction transactionTwo = new Transaction(itemNoTwo);
//            Transaction transactionTree = new Transaction(itemNoTree);
//
//            kch.getTransactionList().add(transactionOne);
//            kch.getTransactionList().add(transactionTwo);
//            kch.getTransactionList().add(transactionTree);
//
//
//            Achievement achievementOne = new Achievement(questRepository.findById(1L).orElse(null));
//            Achievement achievementTwo = new Achievement(questRepository.findById(1L).orElse(null));
//            Achievement achievementTree = new Achievement(questRepository.findById(1L).orElse(null));
//
////            achievementOne.setQuest(questNoOne);
////            achievementTwo.setQuest(questNoTwo);
////            achievementTree.setQuest(questNoTwo);
//
//            kch.getAchievementList().add(achievementOne);
//            kch.getAchievementList().add(achievementTwo);
//            kch.getAchievementList().add(achievementTree);
//
//
//            studentService.addStudent(kch);
//
//
//            kch.getTransactionList().add(new Transaction(itemRepository.findById(1L).orElse(null)));
//
//            Request req1 = new Request(itemRepository.findById(1L).orElse(null));
//            requestRepository.save(req1);
//
//
//            com.codecool.fusy_qs.entity.RequestDetails firstReq = new com.codecool.fusy_qs.entity.RequestDetails(req1, kch, 10);
//            com.codecool.fusy_qs.entity.RequestDetails firstReq2 = new com.codecool.fusy_qs.entity.RequestDetails(req1, kch, 10);
//            requestDetailsReposiotry.save(firstReq);
//            requestDetailsReposiotry.save(firstReq2);


            for(Achievement achi : kch.getAchievementList()){
                System.out.println(achi.getQuestDescription());
            }

            for(Transaction trans : kch.getTransactionList()){
                System.out.println(trans.getItemDescription());
                System.out.println(trans.isUsed());
            }


        };

    }
}
