package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.Quest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    public UserController() {

    }

//    @GetMapping("/quests")
//    String showStudentsQuests(Model model) {
//
//        List<Quest> allQuests = questService.getAllQuests();
//        for (Quest quest : allQuests) {
//            System.out.println(quest.toString());
//        }
//
//        return "students/allRecords";
//    }

//    @GetMapping("/transactions")
//    String showTransaction(Model model) {
//        Student student = studentService.getStudentById(")+e)CWq!");
//
//        Group group = groupService.getGroupById(student.getGroupId());
//        Level level = levelService.getLevelByCcReq(student.getTotalCoinsEarned());
//
//        model.addAttribute("student", student);
//        model.addAttribute("group", group);
//        model.addAttribute("level", level);
//
//        return "students/transactions";
//
//    }

}
