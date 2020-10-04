package com.codecool.fusy_qs;



import com.codecool.fusy_qs.Group.Model.Group;
import com.codecool.fusy_qs.Mentor.Model.Mentor;
import com.codecool.fusy_qs.Mentor.Service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MentorController {
        private MentorService mentorService;

    public MentorController(MentorService mentorService) {this.mentorService = mentorService;}

    @GetMapping("/mentor")
    String showMentorPage(Model model) {
        Mentor mentor = mentorService.getMentorById("bIx0U[5~");
        ArrayList<Group> groups = mentorService.getMentorsGroupsById("bIx0U[5~");
        Integer count = groups.size();
        model.addAttribute("mentor", mentor);
        model.addAttribute("groups",groups);
        model.addAttribute("count", count);
        return "mentors/profile";
    }

    @GetMapping("/newstudent")
    String showNewStudentPage(Model model) {
        Mentor mentor = mentorService.getMentorById("bIx0U[5~");
        model.addAttribute("mentor", mentor);
        return "mentors/add-student";
    }

    @GetMapping("/classes")
    String showClassesPage(Model model) {
        Mentor mentor = mentorService.getMentorById("bIx0U[5~");
        model.addAttribute("mentor", mentor);
        return "mentors/classes";
    }

    @GetMapping("/groups")
    String showGroupsPage(Model model) {
        Mentor mentor = mentorService.getMentorById("bIx0U[5~");
        model.addAttribute("mentor", mentor);
        return "mentors/groups";
    }


}
