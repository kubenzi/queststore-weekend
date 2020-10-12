package com.codecool.fusy_qs;

import com.codecool.fusy_qs.entity.Quest;
import com.codecool.fusy_qs.service.QuestService;
import com.codecool.fusy_qs.service.QuestTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    QuestService questService;

    public UserController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping("/quests")
    String showStudentsQuests(Model model) {

        List<Quest> quests = questService.getAllGroupQuests();


        model.addAttribute("quests", quests);

        return "students/allRecords";
    }

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
