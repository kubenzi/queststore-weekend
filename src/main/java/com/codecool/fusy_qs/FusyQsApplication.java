package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.Quest;
import com.codecool.fusy_qs.entity.QuestType;
import com.codecool.fusy_qs.repository.QuestRepository;
import com.codecool.fusy_qs.repository.QuestTypeRepository;
import com.codecool.fusy_qs.service.QuestService;
import com.codecool.fusy_qs.service.QuestServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FusyQsApplication {
    private QuestRepository questRepository;
    private QuestTypeRepository questTypeRepository;
    private QuestServiceImpl questService;

    public FusyQsApplication(QuestTypeRepository questTypeRepository,
                             QuestRepository questRepository,
                             QuestServiceImpl questService) {
        this.questTypeRepository = questTypeRepository;
        this.questRepository = questRepository;
        this.questService = questService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FusyQsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {
            QuestType individual = new QuestType("individual");
            QuestType group = new QuestType("group");
            questTypeRepository.save(individual);
            questTypeRepository.save(group);

            questRepository.save(new Quest(individual, "wash your car", 100));
            questRepository.save(new Quest(individual, "clean your bedroom", 100));
            questRepository.save(new Quest(group, "make group project", 400));
            questRepository.save(new Quest(group, "build something", 500));

            List<Quest> allQuests = questService.getAllQuests();
            System.out.println(allQuests.size());
        };
    }
}
