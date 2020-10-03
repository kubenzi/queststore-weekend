package com.codecool.fusy_qs;


import com.codecool.fusy_qs.Group.Group;
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
    String showStudentPage(Model model) {
        Mentor mentor = mentorService.getMentorById("bIx0U[5~");

        model.addAttribute("mentor", mentor);

        return "mentors/profile";
    }

}
