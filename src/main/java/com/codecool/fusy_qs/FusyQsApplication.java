package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.GroupClass;
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

    public FusyQsApplication(QuestServiceImpl questService, QuestTypeService questTypeService, AccountTypeService accountTypeService, GroupServiceImpl groupService, StudentRepository studentRepository, GroupRepository groupRepository, UserRepository userRepository, UserService userService, StudentService studentService) {
        this.questService = questService;
        this.questTypeService = questTypeService;
        this.accountTypeService = accountTypeService;
        this.groupService = groupService;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FusyQsApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {



            GroupClass java = groupService.findGroupById(1L);

            GroupClass csharp = groupService.findGroupById(2L);

//
//            User user = userService.findUserById(410L);
//            System.out.println(user.getEmail());

//            Student student = studentService.findStudentById(1L);
//            System.out.println(student.getEmail());


//            Student student = new Student("B", "J", "bj@gmail.com", "1234", accountTypeService.findAccountTypeById(1L), 0, 0);
//            studentRepository.save(student);
//
//
//            student.getGroups().add(java);
//
//            studentService.addStudent(student);
//
//            java.getUsers().add(student);

            System.out.println(questTypeService.findQuestTypeById(1L).getQuestTypeName());



//            System.out.println(kch.getEmail());


//            System.out.println(java.getUsers().size());
//            System.out.println(bj.getGroups().size());


//
//            bj.getGroups().add(java);
//            bj.getGroups().add(csharp);
//
//
//            kch.getGroups().add(java);
//            kch.getGroups().add(csharp);
//
////            przemo.getGroups().add(java);
////            przemo.getGroups().add(csharp);
//
//            userRepository.save(bj); userRepository.save(kch);
//
//
//            java.setUsers(Arrays.asList(bj, kch));
//            csharp.setUsers(Arrays.asList(bj, kch));
//
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
